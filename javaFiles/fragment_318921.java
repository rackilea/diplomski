public static String delSpaces(String str){    //custom method to remove multiple space
        StringBuilder sb=new StringBuilder();
        for(String s: str.split(" ")){

            if(!s.equals(""))        // ignore space
             sb.append(s+" ");       // add word with 1 space

        }
        return new String(sb.toString());
    }