public class tester
{
    public static void main(String[] args)
    {            
        int[] results = rtd.rollthedice(6, 20);

        // Since counter starts with 0, we always add 1 so we can read from 1 to 20            

        for (int counter = 0; counter < results.length; counter++)
        {
            System.out.println("Roll Number: " + (counter + 1) + " Side Picked: " + results[counter]);            
        }
    }
}