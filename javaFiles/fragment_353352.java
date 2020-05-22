public static void main(String[] args) {

    System.out.println("enter name: "); 
    String ctName = console.next();

    EmpCls empObject1 = new EmpCls(ctName);

    System.out.println("You just enter " + empObject1.getName()); 
}