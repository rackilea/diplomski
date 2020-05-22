import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.builder.CompareToBuilder;

public class Tester {

    boolean ascending = true ;


    boolean sortInstrumentIdAsc = true ;
    boolean sortEventTypeIdAsc = true ; 


    public static void main(String args[]) {
        Tester tester = new Tester() ;
        tester.printValues() ;
    }

    public void printValues() {

        List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("actionId", new Integer(1234));
        map.put("eventId", new Integer(21));
        map.put("fromDate", getDate(1));
        map.put("toDate", getDate(7));
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("actionId", new Integer(456));
        map.put("eventId", new Integer(11));
        map.put("fromDate", getDate(1));
        map.put("toDate", getDate(1));
        list.add(map);


        map = new HashMap<String, Object>();
        map.put("actionId", new Integer(1234));
        map.put("eventId", new Integer(20));
        map.put("fromDate", getDate(4));
        map.put("toDate", getDate(16));
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("actionId", new Integer(1234));
        map.put("eventId", new Integer(22));
        map.put("fromDate", getDate(8));
        map.put("toDate", getDate(11));
        list.add(map);


        map = new HashMap<String, Object>();
        map.put("actionId", new Integer(1234));
        map.put("eventId", new Integer(11));
        map.put("fromDate", getDate(1));
        map.put("toDate", getDate(10));
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("actionId", new Integer(1234));
        map.put("eventId", new Integer(11));
        map.put("fromDate", getDate(4));
        map.put("toDate", getDate(15));
        list.add(map);


        map = new HashMap<String, Object>();
        map.put("actionId", new Integer(1234));
        map.put("eventId", new Integer(11));
        map.put("fromDate", getDate(8));
        map.put("toDate", getDate(30));
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("actionId", new Integer(567));
        map.put("eventId", new Integer(12));
        map.put("fromDate", getDate(-1));
        map.put("toDate", getDate(1));
        list.add(map);


        System.out.println("\n Before Sorting \n ");
        for (int j = 0; j < list.size(); j++) {
              System.out.println(list.get(j));
        }

        // sort the list
        HashMapComparator2 comparator = new HashMapComparator2();
        Collections.sort(list, comparator);

        System.out.println("\n After Sorting \n ");
        for (int j = 0; j < list.size(); j++) {
              System.out.println(list.get(j));
        }


        HashMap<String, Object> prev = null;
        List<HashMap<String, Object>> same = new ArrayList<HashMap<String, Object>>();
        for (HashMap<String, Object> row : list) {
              if (prev != null) {
                    int diff = comparator.compare(prev, row);
                    if (diff == 0) {
                          same.add(row);
                          same.add(prev);
                    }
                    else {
                          merge(same);
                          same.clear();
                    }
              }
              prev = row;
        }
        merge(same);

        System.out.println("\n After Merging \n ");
        for (int j = 0; j < list.size(); j++) {
              System.out.println(list.get(j));
        }
  }

  private void merge(List<HashMap<String, Object>> same) {
        if (!same.isEmpty()) {
              // Now find min max
              Date min = null;
              Date max = null;
              for (HashMap<String, Object> i : same) {
                    Date from = (Date) i.get("fromDate");
                    Date to = (Date) i.get("toDate");
                    if (min == null) {
                          min = from;
                    }
                    else if (from.before(min)) {
                          min = from;
                    }
                    if (max == null) {
                          max = to;
                    }
                    else if (to.after(max)) {
                          max = to;
                    }
              }
              for (HashMap<String, Object> i : same) {
                    i.put("fromDate", min);
                    i.put("toDate", max);
              }
        }
  }


    public static Date getDate(int days) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, days);
        return cal.getTime() ;        

    }

    public class HashMapComparator2 implements Comparator
    {
        public int compare ( Object object1 , Object object2 )
        {
            if ( ascending == true )
            {
                return new CompareToBuilder()
                .append(( ( HashMap ) object1 ).get ( "actionId" ), ( ( HashMap ) object2 ).get ( "actionId" ))
                .append(( ( HashMap ) object2 ).get ( "eventId" ), ( ( HashMap ) object1 ).get ( "eventId" ))
                .toComparison();
            }
            else
            {
                return new CompareToBuilder()
                .append(( ( HashMap ) object2 ).get ( "actionId" ), ( ( HashMap ) object1 ).get ( "actionId" ))
                .append(( ( HashMap ) object2 ).get ( "eventId" ), ( ( HashMap ) object1 ).get ( "eventId" ))
                .toComparison();
            }
        }
    }


}