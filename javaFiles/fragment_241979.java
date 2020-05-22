LinkedList<int[]> list = new LinkedList();

int bar = new int[] {1,2,3};
list.addLast(bar);

boolean found = false;
int foo = new int[] {1,2,3};

for (int[] arr : list) {
   if (Arrays.equals(foo, arr)) {
     found = true;
     break; // search no more
   }
}

if (found) {
     System.out.print("I found foo!");
} else {
   System.out.print("I didn't find foo.");
}