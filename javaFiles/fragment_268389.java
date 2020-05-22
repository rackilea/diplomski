for(String year: yearList){
   List<String> hurricanes = map.get(year);
   for (String hurricane: hurricanes){
        System.out.println(hurricane);
   }
  }