BitSet bitset = new BitSet();
// adding default values as one
for (int a = 0; a < firstList.size(); a++) {
    comparingList.add(0);

}

for (int counter = 0; counter < firstList.size(); counter++) {
    for (int counter2 = 0; counter < secondList.size(); counter++) {
        if (secondList.get(counter2).equals(firstList.get(counter))) {
            bitset.set(counter, 1);
        }
    }
}