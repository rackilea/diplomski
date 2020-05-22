public static void main(String[] args){
    MyTest test = new MyTest();
    if (test.equals(new MyTest())  // no need for "== true", it's already boolean
       System.out.print("It is valid")
    else
       System.out.print("It is NOT valid")
}