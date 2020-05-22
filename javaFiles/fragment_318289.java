public static void Main() {
    new YourMap<Integer, Integer> myMap = new YourMap<Integer, Integer>();
    int state = myMap.getState();
    myMap.put(1, 2);
    System.out.println(myMap.isUpdated(state));  // will print true.
    if (!myMap.isUpdated()) {  // in this demo, it will never go in this if.
        // call your process...
    }
}