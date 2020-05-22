//This is the method that will be called from some other class
   public static int printSequence(int n){
       return printSequence(1, n);
   }

   /*We define this method, because the following code snippet
    is used multiple times in the method 'printSequence(int, int)'
    This method will simply print the numbers 1 - length*/
   private static void printLooper (int length){
        for(int i=1; i<=length; i++)
            System.out.print(i);
        System.out.print("\n");
    }

    /*This method has the logic. We give it 2 integers as parameters:
     int start and int end. I think the names of the parameters are self-explanatory*/
    private static int printSequence(int start, int end){
        /*This is the TERMINATING condition, so it is placed first.
         This part is really important. Always be aware of what type of recursion
         you are using. More on this later..*/
        if ( end == 1 ) {
            printLooper(end);
            return 0;
        }

        //OK. So, if start is less than end, then print 1 - start
        if (start < end){
            printLooper(start);
            //then return method recursively, with start INCREMENTED by one
            return printSequence(start+1, end);
        }

        /*Now, if start is equal to end, print number 1 - start, but this time,
        return the method recursively with end DECREMENTED by one*/
        else if (start == end){
            printLooper(start);
            return printSequence(start, end-1);
        }

        /*Now if start is larger than end, then that means that we need to start
         printing the lower part of the 'number tree'. So, call printLooper()
         to print 1 - end.*/
        else if (start > end){
            printLooper(end);
            return printSequence(start, end-1);
        }
        return 0;
    }