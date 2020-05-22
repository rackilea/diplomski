public Comparator<ModelMap> getComparator(final String sortBy){
   if ("surname".equals(sortBy)) {
   return new Comparator<ModelMap>() {
   @Override int compare(ModelMap m1, ModelMap m2) 
    return m1.getSurname().compareTo(m2.getSurname());
   }};} 
     else if (condition) {// ...  }
      else {
        throw new IllegalArgumentException("invalid sort field '" + sortBy + "'"); }
       }