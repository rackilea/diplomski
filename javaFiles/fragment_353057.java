public class Main
{
    public static void main(String[] args)
    {
        float averages[] = new float[5];
        int aLotOfNumbers[] = new int[100];

        // Initialize the numbers to 0, 1, 2, 3, 4, ..., 99
        for(int i=0; i<100; i++)
        {
            aLotOfNumbers[i] = i;
        }

        // Compute the averages by summing groups of 20 numbers and dividing the sum by 20
        for(int i=0; i<5; i++)
        {
            float runningSum = 0.0f;
            for(int j=0; j<20; j++)
            {
                runningSum += aLotOfNumbers[i*20 + j];              
            }
            averages[i] = runningSum / 20.0f;
        }

        // Print the 5 average values
        for(int i=0; i<5; i++)
        {
            System.out.println("Average[" + i + "] = " + averages[i]);
        }
    }
}