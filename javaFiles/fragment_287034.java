public static String NextNumber(String currentNumber) {
    //assume yymmddnnn
    String sDateNum = currentNumber.substring(0, 6);
    String sCurrentNum = currentNumber.substring(6,9);
    int i = Integer.valueOf("1" + sCurrentNum);
    i++;

    return sDateNum + String.valueOf(i).substring(1, 4);
}



    System.out.println(NextNumber("130621001"));