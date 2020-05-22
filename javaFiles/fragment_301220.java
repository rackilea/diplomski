public Date3( String m, int d, int y){
    this(convMonth(m), d, y);
}
public static int convMonth(String m) {
    int index =1; // january will be 1
    for(String month : months) {
        if(m.equals(month)) break;
        index++;
    }
    return index;
}