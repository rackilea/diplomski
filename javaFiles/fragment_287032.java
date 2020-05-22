LinkedList <Integer> list = new LinkedList<Integer>() ;
//... code omitted (adds every number)
int initialSize = list.size();
for( int i = 0 ; i < initialSize; i++) {   
  list.add(list.get(i));
}

System.out.println(list);