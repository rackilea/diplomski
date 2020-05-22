class MyString { 

    private final String s; 

    public MyString(String s){ 
        this.s = s; 
    } 

    public String toString(){ 
        return s; 
    } 

    public static void main(MyString[] args) { // <--------- oh no!
        MyString s = new MyString("Hello world"); 
        System.out.println(s); 
    } 
}