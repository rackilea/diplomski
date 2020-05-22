public static String hexToString(String hex)
    {       
       StringBuilder output = new StringBuilder();
       String str = "";
       for (int i = 0; i < hex.length(); i+=2)
       {

        if(i+2 < hex.length()){
            str = hex.substring(i, i+2);
        }else{
            str = hex.substring(i, i+1);
        }
        output.append((char)Integer.parseInt(str, 16));
       }
       return(output.toString());
    }