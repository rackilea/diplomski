String biggest = list.get(0);
 String smallest = list.get(0);
 for (int i = 1; i < list.size(); i++) {
    if(list.get(i).compareToIgnoreCase(biggest) > 0)
       biggest = list.get(i);
    if(list.get(i).compareToIgnoreCase(smallest) < 0)
       smallest = list.get(i);
}