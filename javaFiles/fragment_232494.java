public class Main {
    public static void main(String[] args) {
       try{
            Date date1 = new Date(2020, 13, 33);
       } catch(DateTimeException ex){
            System.out.println("Invalid input");
       }
    }
}