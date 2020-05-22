StringBuilder stringBuilder = new StringBuilder();
    String[] strArray = new String[5]; //or some big number
    for(int c = 0;c < 5;c++)
    {
        stringBuilder.append(strArray[c]);
    }
    System.out.println(stringBuilder.toString());