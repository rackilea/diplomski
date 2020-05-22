public int someValue() {
    int value = 0;
    for(int i = 0; i < someString.length; i++) {
         if(someString.charAt(i) == ' ') value++;
    }
    return value;
}