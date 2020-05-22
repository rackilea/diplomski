String str1 = "001";
    String str2 = "101";
    char charArray1[] = str1.toCharArray();
    char charArray2[] = str2.toCharArray();
    String str = "";

    for(int i=0; i<charArray1.length; i++){
        if(charArray1[i] != charArray2[i])
        {
            charArray2[i] = 'X';
        }       else
    str = new String(charArray2);
    }
    System.out.print(str1 + " is now : " + str + "\n");