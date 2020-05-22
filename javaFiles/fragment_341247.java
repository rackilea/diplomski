String[] strArray = { "a", "b", "c" };
    Integer[] intArray = { 1, 2, 3 };
    Object[] arr = new Object[strArray.length + intArray.length];
    int j = 0;
    for (int i = 0; i < strArray.length; i++) {
        arr[j++] = strArray[i];
    }
    for (int i = 0; i < intArray.length; i++) {
        arr[j++] = intArray[i];
    }