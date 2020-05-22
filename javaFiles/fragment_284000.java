public class Array {

public static void main(String[] args) {

    //pax(p) = Single, Double, Triple
    //p1=0 , p2=1, p3=2

    //basis(b) = RO, BB, HB, FB
    //b1=3 , b2=4 , b3=5 , b4=6

    int[][] array = { 
              {100, 12 , 0, 3},
              {100, 177, 0, 3},
              {100, 233, 0, 3}, 
              {100, 144242, 0, 3},
              {100, 14, 0, 4},  
              {100, 12234, 0, 4},
              {100, 134, 1, 4},
              {2, 15, 0, 3},
              {23, 1533, 0, 3},
              {23, 1322, 1, 4}, 
              {23, 13, 1, 4}, 
              {23, 122, 1, 4},
              {1321, 142, 1, 4},
              {1321, 133,1, 4},
              {3, 16, 0, 5},
              {55, 1003, 0,3},
              {553, 1002, 2, 6},
              {31, 162, 0, 5},
              {7, 1626, 0, 5},
              {7, 2336, 0,5}           
             };


    int riid = 0;
    int pax = 10;

    for (int i = 0; i < array.length; i++) {
        if (array[i][0] != riid) {
            riid = array[i][0];
            //System.out.print("\n" + riid + "-" + array[i][1]);
        } else {

           // System.out.print("," + array[i][1]);
        }

        if (array[i][2] != pax) {
            pax = array[i][2];
            System.out.print("\n" + riid + "-" + pax + "-" + array[i][1]);
       } else {
          System.out.print("," + array[i][1]);
       }

    }

}