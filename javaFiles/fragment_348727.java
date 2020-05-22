public class RearrangeArray {

    public static void main(String[] args) {
    // TODO Auto-generated method stub
         double[] arr = {1.0,2.0,3.0,4.0,5.0};
         double[] newArr = new double[arr.length];

         double sum = 0.0;  
         for (int i = 0; i < arr.length; i++)
              sum += arr[i];
         double average = sum / arr.length;

         System.out.println("average = " + average);
         int n = 0;
         for(int i = 0; i < arr.length; i++)
         {
            boolean check = compare(arr[i],average);
            if(check)
            {
                newArr[n] = arr[i];
                n++;
            }
         }

         for (int i = 0; i < arr.length; i++)
         {
            System.out.print(newArr[i] + " ");
         }

    }
    public static boolean compare(double key, double average)
    {
        if(key >= average)
            return true;
        return false;
    }
}