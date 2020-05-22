ArrayList<A> array = new ArrayList<>(); // allocates a single ArrayList object 
// the ArrayList contains an array of references (pointers), all null
for(int i=0; i<10; i++){
   A temp = new A(i); // allocates a new A
   array.add(new A(i)); // stores the pointer to A in the list
}

A fifth = array.get(5); // This object was allocated before, and is unchanged

for(int i=10; i<1000000; i++){
      A temp = new A(i); // Allocates a new A
      array.add(); // Stores the pointer in the list
      // Internally, the List may reallocate its backing array, but it 
      // is an array of References (pointers), not the A objects themselves
}

System.out.println("it's still alive " + fifth.id); // fifth was allocated in line 4
// and is still reachable