public class Test {

    public static void main(String args[]) {
        int[] number = {2,3,7,4,5,1,12,14,9,28}; // 1, 4, -3, 1, -4, 11, 2, -5, 1 <- These are differences from curr - prev

        int totalRun, incRun = 0, decRun = 0; // Not 1, what if theyre all increasing/decreasing? Run never goes to 1.

        for (int i = 0; i < number.length - 1; i++) {
            int prevnum = number[i];
            int currnum = number[i+1];
            int difference = currnum - prevnum;
            if (difference > 0)
                incRun++;
            else
                decRun++;
        }

        if (number[1] > number[0])
            totalRun = incRun;
        else
            totalRun = decRun;

        System.out.println("Total run: " + totalRun);
    }
}