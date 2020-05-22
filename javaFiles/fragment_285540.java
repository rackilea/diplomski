LinkedList<Integer> ll = new LinkedList<Integer>();

int i = 0;
int[] seq = {1, 2, 3, 4};

for (Integer val : ll) {
    assertEquals(seq[i], val);
    i++;
}