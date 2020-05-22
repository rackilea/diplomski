ArrayList <ArrayList> listofList = new ArrayList ();

for (int z = 0; z < 1000; z = z + 16) {

     int endpoint = z + 16;  // check to see not bigger than 1000
     ArrayList thisList = list.subList(z, endpoint);
     listOfList.add (thisList);
     System.out.println(thisList);
}