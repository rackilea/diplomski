package com.willeke.ldap.microsoft;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.unboundid.ldap.sdk.Attribute;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.SearchRequest;
import com.unboundid.ldap.sdk.SearchResultEntry;
import com.unboundid.ldap.sdk.SearchScope;

/**
 * @author jim@willeke.com 
 * 
 */
public class RangeBasedSearch
{
    static String thisClass = RangeBasedSearch.class.getName();
    static Logger log = Logger.getLogger(thisClass);

    /**
     * We can dynamically get the range step value if we get retrieve all attribute names. The range step will be in an attribute like: member;range=0-1499
     * 
     * @param idv_searchldc
     * @param basedn
     * @param filter
     * @param return_attribute
     * @return
     * @throws LDAPException
     */
    public static int getRangeStepValue(LDAPConnection idv_searchldc, String basedn, String filter, String return_attribute) throws LDAPException {
      SearchRequest searchRequest = new SearchRequest(basedn, SearchScope.BASE, filter, SearchRequest.ALL_USER_ATTRIBUTES);
      List<SearchResultEntry> rangedEntries = idv_searchldc.search(searchRequest).getSearchEntries();
      for (Iterator<SearchResultEntry> iterator = rangedEntries.iterator(); iterator.hasNext();) {
        SearchResultEntry searchResultEntry = iterator.next();
        Collection<Attribute> allAttribute = searchResultEntry.getAttributes();
        for (Iterator<Attribute> attributeIterator = allAttribute.iterator(); attributeIterator.hasNext();) {
          Attribute attribute = attributeIterator.next();
          log.debug("---> " + attribute.getName());
          String rangeCheckAttribute = return_attribute + ";range=0-";
          if (attribute.getName().contains(rangeCheckAttribute)) {
            int rangeStep = Integer.parseInt(attribute.getName().substring(attribute.getName().lastIndexOf(rangeCheckAttribute) + rangeCheckAttribute.length()));
            log.debug("Range Step is: " + rangeStep);
            return rangeStep;
          } else {
            return 0; //rangebasedSearchNot Needed
          }
        }
      }
      return 0;
    }

    public static List<String> getAttributeRangeBasedSearch(LDAPConnection ldc, String basedn, String filter, String return_attribute) throws LDAPException {
      int step = getRangeStepValue(ldc, basedn, filter, return_attribute);
      return getAttributeRangeBasedSearch(ldc, basedn, filter, return_attribute, step);
    }

    /**
     * 
     * @param ldc
     * @param basedn
     * @param filter
     * @param step
     *            - How can we dynamically determine the step?
     * @param return_attribute
     * @return
     * @throws LDAPException
     */
    public static List<String> getAttributeRangeBasedSearch(LDAPConnection ldc, String basedn, String filter, String return_attribute, int step) throws LDAPException {
      int initialStep = step;
      List<String> allValues = new ArrayList<String>();
      // initialize counter to total the return_attribute values and range values
      int start = 0;
      int finish = step;
      boolean finallyFinished = false;
      String range;
      // loop through the query until we have all the results
      while (!finallyFinished) {
        range = start + "-" + finish;
        String currentRange = null;
        if(step==0) {
          currentRange = return_attribute;
        } else {
          currentRange = return_attribute + ";Range=" + range;
        }
        String range_returnedAtts[] = { currentRange };
        SearchRequest searchRequest = new SearchRequest(basedn, SearchScope.BASE, filter, range_returnedAtts);
        List<SearchResultEntry> rangedEntries = ldc.search(searchRequest).getSearchEntries();
        for (Iterator<SearchResultEntry> iterator = rangedEntries.iterator(); iterator.hasNext();) {
          SearchResultEntry searchResultEntry = iterator.next();
          Collection<Attribute> allAttribute = searchResultEntry.getAttributes();
          for (Iterator<Attribute> attributeIterator = allAttribute.iterator(); attributeIterator.hasNext();) {
            Attribute attribute = attributeIterator.next();
            log.debug("---> " + attribute.getName());
            // The last batch returns this as member;range=28500-*
            if (attribute.getName().endsWith("*")||step==0) {
              currentRange = attribute.getName();
              finallyFinished = true;
            }
            String[] attributeBatch = searchResultEntry.getAttributeValues(currentRange);
            for (int i = 0; i < attributeBatch.length; i++) {
              allValues.add(attributeBatch[i]);
              // log.debug("-- " + allvalues++ + " " + attribute.getName() + ":" + attributeBatch[i]);
            }
          }
        }// for SearchResultEntry
        start = finish + 1;
        finish = finish + step;
      }// finallyFinished
      log.info("Total " + return_attribute + " Entries found: " + allValues.size() + " ( initialStep=" + initialStep + ")");
      return allValues;
    }
  }