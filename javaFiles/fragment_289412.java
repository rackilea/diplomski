public static void main(String args[] )
{
   int[] iArr = {1};
   int[] newArr = method(iArr) ;
   System.out.println( "iArr[0] = " + iArr [0] ) ;
   // This is different here, but it would "be the same" in the 
   // 2nd-case example in the post.
   System.out.println( "newArr[0] = " + newArr [0] ) ;
}
public static int[] method(int[] n ) {
    // This is a silly stub method, n would be presumably used.
    int[] x = new int[1];
    x[0] = 45; // modifying a DIFFERENT object
    return x;  // returning the NEW object
}