public void method1(List s) {
    String[] array = s.toArray(new String[s.size()]);  // <-- pass the array as an argument
    for (int i = 0; i < array.length; i++) {
        System.out.println(array[i]);
    }
}