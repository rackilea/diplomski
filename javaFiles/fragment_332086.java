public static <T> List<T> createListOfType() {
    return new ArrayList<T>();
}

public static void main(String[] args) {
    List<String> a = createListOfType();    
    List<Integer> b = createListOfType();
    a.add("");
    b.add(2);
    a.add(2); // remove this line to compile
    b.add(""); // remove this line to compile       
}