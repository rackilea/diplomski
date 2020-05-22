for (int i = 0; i < list1.size(); i++) {
  String s1 = list1.get(i).getName();
  System.out.println(s1);
  boolean found = false;
  for (int j = 0; j < list2.size(); j++) {
    String s2 = list2.get(j);
    if(s1.equals(s2)){
      found = true;
      break;
    }
  }
  if(!found){
    list1.remove(i);
    i--;
  }
}