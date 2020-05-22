class Example2{
public void main(String args[]){
    try{
        int a[]=new int[7];
        a[10]=30/0;
        System.out.println("First print statement in try block");
    } catch(ArithmeticException | ArrayIndexOutOfBoundsException  e) {

    }
    System.out.println("Out of try-catch block...");
}