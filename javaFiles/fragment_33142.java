import java.util.*;

class JAVAhw10 {
    private static final int[] table = {3,9,4,1,7,6,8,2,0,5};

    public static void main(String[] args) {

        int a, b, c, d, e;
        a = (int)((Math.random()*100) % (9) + 0);
        b = (int)((Math.random()*100) % (9) + 0);
        c = (int)((Math.random()*100) % (9) + 0);
        d = (int)((Math.random()*100) % (9) + 0);
        e = (int)((Math.random()*100) % (9) + 0);

        int DigitIn[] = new int[5];
        int table[] = new int[10];

        //filling in the arrays
        DigitIn[0]=a;
        DigitIn[1]=b;
        DigitIn[2]=c;
        DigitIn[3]=d;
        DigitIn[4]=e;

        System.out.println("This program ecnrypts 5 random numbers");
        System.out.println(Arrays.toString(DigitIn));

        int[] output = encrypt(DigitIn);
        System.out.println(Arrays.toString(output));

    }

    public static int[] encrypt(int[] input){
       int[] output = new int[input.length];
       for (int i=0; i<input.length; i++){
           output[i] = table[input[i]];
       }
       return output;
    }
}