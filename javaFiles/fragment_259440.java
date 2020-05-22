List<Map<String, Object>> getSearchData(String fdate, String tdate){
   String fromDate = parseDate(fdate);
   String toDate = parseDate(tdate);

   List<Object[]> foundData = retrievePublicationService.getSearchData(fromDate, toDate);

   return mapSearchResultToDropdown(foundData);
}