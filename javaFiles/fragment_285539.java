LinkedList<Integer> ll = new LinkedList<Integer>();
Iterator<Integer> itr = ll.iterator();

int i = 0;
int[] seq = {1, 2, 3, 4};

while (itr.hasNext()) {
    int val = itr.next();
    assertEquals(seq[i], val);
    i++;
}