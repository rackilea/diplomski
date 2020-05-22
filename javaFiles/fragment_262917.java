public static Person createPersoneFromArray(String[] array) {
    Person p = new Person();
    p.setAge(array[0]);
    p.setName(array[1]);
    //...
    return p;
}