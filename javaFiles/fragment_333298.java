public String copyRandom(char[] copyFrom, int[] indexes) {
    char[] output = new char[indexes.length];
    for (int i=0; i < indexes.length; i++)
        output[i] = copyFrom[indexes[i]];
    return new String(output);
}