public static int addNum (int arr[], int n)
        {
          int x = 0;
          if (n > arr.length)
          {
              return 0;
          }
          else if (n == 1)
          {
              //When n == 1, you want to return the first element of your array and not 1
              return arr[0];
          }
          else 
          {
             //As you go deeper into recursion, you break your problem into a smaller problem.
             //Therefore, when calling addNum again, you pass n-1 and not n, as now you want to add remaining n-1 numbers 
             x = arr[n-1] + addNum(arr, n-1);
             // you want to return your sum x and not n
             return x;
          }
         }

        public static void main(String args[])
        {
            int n = 0;
            int arr[] = {1,2,3,4,5,6,7};
            System.out.println("Input your number and press enter: ");
            Scanner in = new Scanner(System.in);
            n = in.nextInt();
            System.out.print("Sum of numbers is:");
            //Your addNum method returns an int, so you want to save it in a variable and then print it 
            int x = addNum(arr, n);
            System.out.println(x);
            }