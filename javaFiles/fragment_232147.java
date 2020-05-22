List<Integer> listOne = new LinkedList<>();
List<Integer> listTwo = new LinkedList<>();
int[] combined = new int[Math.min(listOne.size(), listTwo.size())];
Iterator<Integer> iterOne = listOne.iterator();
Iterator<Integer> iterTwo = listTwo.iterator();
for (int i = 0; i < combined.length; i++) {
    combined[i] = iterOne.next() + iterTwo.next();
}