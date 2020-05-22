public class Doom{
    public static void main(String[] args){
        int number = 1234;
        int[] list = new int[String.valueOf(number).length()];
        int x = 0;
        while (number > 0) {        
            int fork = (number%10);
            System.out.println(fork);
            list[x] = fork;
            x++;
            number = number / 10;
        }
        for (int y : list){
            System.out.println(y);
        }

    }
}