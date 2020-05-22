public static String getIncrementedString(String str){
        StringBuilder sb = new StringBuilder();
        for(char c:str.toCharArray()){
            sb.append(++c);
        }
        return sb.toString();
    }