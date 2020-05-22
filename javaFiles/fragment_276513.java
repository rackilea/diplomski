public class recursion {
    public static void main(String[] args) {
        ...
        Integer num = 1;
        while (num<= endNum){
            num = numberToPrint(endNum, num); // update num value
        }
    }

    public static int numberToPrint(int endNum, int num) {
         System.out.print(num + ", ");
        if (num >= endNum) {
            return num;
        } 
        return num + 1; 
    }
}