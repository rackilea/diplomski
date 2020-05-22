boolean[] m = {true,false,true,true};
    String binaryStr = "";
    for (boolean bit : m) {
        binaryStr = binaryStr + ((bit) ? "1" : "0" );
    }
    int decimal = Integer.parseInt(binaryStr , 2);
    String hexStr = Integer.toString(decimal , 16);