import java.util.Scanner;

class spiral 
{
    private static String getXZForMap(int np)
    {         
        // (dx, dy) is a vector - direction in which we move right now
        int dx = 0;
        int dy = 1;
        // length of current segment
        int segment_length = 1;

        // current position (x, y) and how much of current segment we passed
        int x = 0;
        int y = 0;
        int segment_passed = 0;
        if (np == 0){
            return ("(" + y + ";" + x + ")");
        }
        for (int n = 0; n < np; ++n) {
            // make a step, add 'direction' vector (dx, dy) to current position (x, y)
            x += dx;
            y += dy;
            ++segment_passed;

            if (segment_passed == segment_length) {
                // done with current segment
                segment_passed = 0;

                // 'rotate' directions
                int buffer = dy;
                dy = -dx;
                dx = buffer;

                // increase segment length if necessary
                if (dx == 0) {
                    ++segment_length;
                }
            }
        }
        return("(" + y + ";" + x + ")");
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int NUMBER_OF_POINTS = Integer.valueOf(args[0]);   // or delete this line  
        String spiral_map = getXZForMap(NUMBER_OF_POINTS); // and put your int here
        System.out.println(spiral_map);
    } 
}