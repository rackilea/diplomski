class A1{
    static{
        System.out.println("static block from A1");
    }
}

class B1{
    public static void main(String[] args) throws ClassNotFoundException {
//      Class.forName("A1");//this will invoke static initialization
        Class c=A1.class;//this will not invoke static initialization
    }
}