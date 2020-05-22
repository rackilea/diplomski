List<SomeType> myList = list.subList(1, 2);

synchronized(list) {
    SomeType value = myList.get(0);
    // process value
}