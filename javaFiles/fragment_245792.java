public static void main(String[] args) {
    Set<MyClass> myClasses = new HashSet<>();
    myClasses.add(new MyClass());
    myClasses.add(new MyClass());
    System.out.println(myClasses.size());
}