public static void main(String[] args) {
    // TODO code application logic here
    intro();
    String name = name();
    System.out.println("Welcome " + name);
}
public static String name(){
    System.out.println("Enter Name:");
    String name = sc.next();
    return name;
}