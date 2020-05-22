public class HelloWorld{
    public static void main(String[] args) {
        int[] a = {33,33,5,5,9,8,9,9};
        for(int i = 0; i < a.length; i++)
        {
            int c=1; // we already found one. 
                     // and we initialize this counter inside the loop, 
                     // so that it is reset for each new starting number.
            for(int j = i+1; j< a.length; j++) // we're starting from next number (reason we start with c=1)
            {
                if(a[i] == a[j])
                    c++;

            }
            if(c > 0) {
                System.out.println("First uplicate value: "+ a[i] + " Count: " + c);
                break;      // we have to break out of the outer loop, 
                            // so the inner loop can finish counting duplicates
            }
        }
    }
}