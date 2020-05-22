MyStruct[] array;

if (N <= 26) {
    array = new MyStruct[260];
    for (int i = 0; i < array.length; i++) {
        array[i] = new MyStruct();
    }
}

else {
    array = new MyStruct[N*10];
    for (int i = 0; i < array.length; i++) {
        array[i] = new MyStruct();
    }
}