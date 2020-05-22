public static void displaySplitString(String str)
    {
        String pattern1 = "^'?(\\w+)'?(?=\\S)";
        str = str.replaceAll(pattern1, " $1 ");
        StringTokenizer strTok = new StringTokenizer(str, " , "); 
        while (strTok.hasMoreTokens()) 
        {
            String delim = (strTok.nextToken()); 
            System.out.println(delim); 
        }
    }