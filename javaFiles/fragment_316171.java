public class MergeSort {

    private static int[] ar = new int[6];

    public static void main(String[] args) throws Exception {
        ar[0]=5;ar[1]=4;ar[2]=3;ar[3]=2;ar[4]=1;ar[5]=0;
        // note: could also do this:
        // ar = = new int[6] { 5, 4, 3, 2, 1, 0 };


        MergeSort s=new MergeSort();
        s.mergesort(0, "", ar);

        // fwiw... all of the methods and members (well, just 'ar')
        // are static so the following is equivalent to the above.
        //    MergeSort.mergesort( 0, "", ar );
    }

    // added: depth & label to provide context for recursion.
    static int[] mergesort(int depth, String label, int[] arr){
        printArray(depth, ">mergesort"+label, arr);
        //System.out.println(" ");

        int size=arr.length;

        if(size >= 2) {
           int[] ar1=new int[size/2];
           int[] ar2=new int[size-ar1.length];
           System.arraycopy(arr, 0, ar1, 0, ar1.length);
           System.arraycopy(arr, ar1.length, ar2, 0, ar2.length);
           // note that we're appending labels so all subsequent
           // calls to mergesort() will have their 'lineage' baked
           // into the label.
           mergesort( 1+depth, label+":ar1", ar1);
           mergesort( 1+depth, label+":ar2", ar2);
           merge(depth, ar1, ar2, arr);
        }
        printArray(depth, "<mergesort"+label, arr);
        return arr; // single return point.
    }

    // added: depth & label aren't so useful here, but just for fun.
    static int[] merge(int depth, int[] ar1,int[] ar2,int[] temp){
       // note: tweaked spacing here to make these line up "nicely"
       // with the longer labels below, like "temp.afterWHile".
       // (output looks better, here just looks messy).
       printArray( depth, ">merge:ar1     ", ar1 );
       printArray( depth, " merge:ar2     ", ar2 );
       printArray( depth, " merge:temp    ", temp );

       int pointer1=0;
       int pointer2=0;
       int pointer3=0;
       while(pointer1 < ar1.length && pointer2 < ar2.length){
          if(ar1[pointer1] < ar2[pointer2]){
             temp[pointer3]=ar1[pointer1];
             pointer1++;
          }
          else{
             temp[pointer3] = ar2[pointer2];
             pointer2++;
          }
          pointer3++;
       }
       printArray( depth, " temp.afterWhile", temp );
       System.arraycopy(ar1, pointer1, temp, pointer3, ar1.length - pointer1);
       printArray( depth, " temp.acopyAR1 ", temp );
       System.arraycopy(ar2, pointer2, temp, pointer3, ar2.length - pointer2);
       printArray( depth, "<merge.acopyAR2 ", temp );
       return temp;
    }

    // wrote a simple printArray() that uses depth & label.
    static void printArray( int depth, String label, int[] array ) {
       for( int i = 0; i < depth; ++i ) {
          System.out.print("|   "); // indent to depth.
       }
       System.out.print( label );
       System.out.print( " len="+array.length+" [ " );
       String delim = "";
       for( int i = 0; i < array.length; ++i ) {
          System.out.print( delim + array[i] );
          delim = ", ";
       }
       System.out.println( " ]"); // end the line we just created.
    }
}