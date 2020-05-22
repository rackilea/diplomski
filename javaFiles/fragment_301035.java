for (j = 1; j < inputArray.length; j++) {
    i = j - 1;
    key = inputArray[j];
    while (i >= 0) {
        if (key.compareTo(inputArray[i]) >= 0) {
            break;
        }
        inputArray[i+1] = inputArray[i];
        i--;
    }
    inputArray[i+1] = key;
    A.moveTo(i+1);
    A.insertBefore(j); // insert 'key' in right place
    A.moveTo(j+1);
    A.delete(); // remove old occurrence of 'key'
}