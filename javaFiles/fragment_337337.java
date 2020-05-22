public class Server {
    public static String checkFalse(int[] array){
        String checker = "Error, the numbers are not in order";
        int number = 0;

        for(int i =0; i<array.length-1; i++){
            number = array[i];
            if(array[i+1] < number){
                return checker;
            }
        }
        return "The numbers are in order!";  
    }
}