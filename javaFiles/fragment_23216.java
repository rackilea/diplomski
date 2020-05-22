int index = 0;

while (index < BitSet.length()) {
    index = BitSet.nextSetBit(index);
    list.append(index);
    index++;
}