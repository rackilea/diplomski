List<List<String>> myList  = new ArrayList<ArrayList<String>>();
myList.push( new LinkedList<String>() );   // impossible to catch, because java don't have generic in runtime

ArrayList<ArrayList<String>> list2 = (ArrayList<ArrayList<String>>) myList; // ok

ArrayList<String> something = list2.get(0);  // doh! impossible to assign LinkedList to ArrayList