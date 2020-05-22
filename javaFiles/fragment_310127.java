static int[] trimArr(int[] oldArr, int count) {    
    int[] tempArr = new int[count];
    int j = 0;

    for (int i = 0; i < count - 1; i++) {
        int currentElement = oldArr[i];
        if (currentElement != oldArr[i + 1])
            tempArr[j++] = currentElement;

    }
    tempArr[j++] = oldArr[count - 1];

    int[] trimmedArr = new int[j];
    for (int i = 0; i < j; i++) {
        trimmedArr[i] = tempArr[i];
    }
    return trimmedArr;
}