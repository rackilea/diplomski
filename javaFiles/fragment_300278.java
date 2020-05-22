public boolean add(PkVisit pkVisit) {
   boolean added = false;
   added = getPkVisits().add(pkVisit);
   if (added) {
       pkVisit.setReportCriteriaBean(this);
   }
   return added;
}