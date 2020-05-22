public void printNumbers(ArrayList<? extends Number> list) {
    list.forEach(System.out::println);
}

ArrayList<Integer> listInt = new ArrayList<Integer>();
printNumbers(listInt); // works
ArrayList<Double> listDbl = new ArrayList<Double>();
printNumbers(listDbl); // also works