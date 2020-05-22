public TestArray(int i){
    a = new Word[i];
    for (int index = 0; index < i; index++) {
        a[index] = new Word(0); // Or some other default besides 0, like -1
    }
}