private static final String[] myTable = {"NUL", "SOH", ... };
public String getCharAsString(char value) {
    if(value <= (char) 0x1F) {
        return myTable[value];
    } else {
        return "" + value;
    }
}