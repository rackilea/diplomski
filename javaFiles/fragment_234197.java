public static String delDel(String str) {
    StringBuilder sb = new StringBuilder(str);
    if(str.length() < 3){
       return str;
    }
    else if(str.substring(1, 4).equals("del")){
        StringBuilder afterRemove = sb.delete(1, 4);
        return afterRemove.toString();
    }
    else{
       return str;
    }
}