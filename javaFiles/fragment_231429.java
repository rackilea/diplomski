public static String[] colArray(int length) {   

    String[] result = new String[length];

    String colName = "";
    for(int i = 0; i < length; i++) {

        char c = (char)('A' + (i % 26));
        colName = c + "";
        if(i > 25){
            colName =  result[(i / 26) - 1] + "" + c;
        }
        result[i] = colName;
    }
    return result;
}