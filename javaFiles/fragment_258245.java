public static  void main(String[] args){
    System.out.println(uncompress("abasd4a4b4c"));
}

public static String uncompress(String text){
    return uncompress(text, "", "");
}

public static String count(char ch, int n){
        if(n == 0){return "";}
        return "" + ch + count(ch, n-1);
    }

public static String uncompress(String text, String count, String output){
    if(text.equals("")){
        return output;

    }else if(Character.isLetter(text.charAt(0))){
        try{
            output += count(text.charAt(0), Integer.parseInt(count));
        }catch(NumberFormatException nfe){
            output += text.charAt(0);
        }
        count = "";
    }else if(Character.isDigit(text.charAt(0))){
        count += ("" + text.charAt(0));
    }
    return uncompress(text.substring(1), count, output);
}