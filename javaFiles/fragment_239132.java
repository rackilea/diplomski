public static int ByLogs(int n)

{
    double y = Math.floor(Math.log(n)/Math.log(2));
    return (int)Math.pow(2, y + 1);
}

public static void main(String[] args)
{
    int input_array[] = {-1,2,4,0,3};
    int [] segment_array;
    int n = input_array.length;

    //for positive n 
    if( (n & (n - 1)) == 0 ) {
        segment_array = new int[(2*(input_array.length))-1];
    } else {
        segment_array = new int[(2*(ByLogs(input_array.length)))-1];
    }

    //Arrays.fill(segment_array,999);

    System.out.println(segment_array.length);
}