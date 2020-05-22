//this part of genCode is not explained above
 public static final int getIdForPos(int x, int y, int area){
    switch (y) {
    case 0: return row_0(x);
    case 1: return row_1(x);
    //.. lots of rows
    default: return 0;
    }
 }

 //but this part is generated with the code above
 public static int row_0(int x){
    switch (x) {
    case 0: return 4711;
    case 1: return 815;
    //.. lots of columns
    default: return 0;
    }
}