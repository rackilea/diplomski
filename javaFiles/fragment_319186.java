Class<?> enclosing = Root.class;

try{
    Class<?> anon1 = enclosing.getClassLoader().loadClass(enclosing.getName() + "$1");
    System.out.println(anon1); // prints: class Root$1
} catch (ClassNotFoundException e) {
    System.out.println("no anonymous classes");
}