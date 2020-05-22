public static void main(String[] args) {

  // create an empty array deque with an initial capacity
  List<Integer> list = new ArrayList<Integer>(8);

  // use add() method to add elements in the deque
  list.add(15);
  list.add(30);
  list.add(20);
  list.add(18);        

  // let us print all the elements available in deque
  for (Integer number : list) {
     System.out.println("Number = " + number);
  }

  Collections.shuffle(list);
  Deque<Integer> deque = new ArrayDeque<Integer>(list);
  // getFirst() will retrieve element at first(head) position
  int retval = deque.getFirst();
  System.out.println("Retrieved Element is = " + retval);
}