List<Object> values = new ArrayList<Object>();
values.addAll(hmap.values());
Collections.sort( values, new Comparator<Object>(){ 
 public int compare(Object o1,
                   Object o2){
    //do specific comparison here
 });