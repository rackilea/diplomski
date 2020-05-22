public class Example {
    public static void main(String[] args) {
        for(int i = 0; i < 40; i++){
            if(i < 20){  //Does this 20 here is initialized again and again
               System.out.println("less than 20");
            }else{
               System.out.println("greater than 20");
            }
        }
    }
}