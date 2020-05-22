String className = new Scanner(System.in).readLine();
try {
    Class<?> unknownClass = Class.forName(className);
    System.out.println("Successfully found " + unknownClass.toString());
} catch(ClassNotFoundException e) {
    System.out.println(className+" doesn't exist!");
}