public static List<String> parse(String s){
    List<String> tokens = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int commaCounter = 0;

    for (char ch: s.toCharArray()){
        if (ch==',' && ++commaCounter == 4){
            tokens.add(sb.toString());
            sb.delete(0, sb.length());
            commaCounter = 0;
        }else{
            sb.append(ch);
        }
    }
    if (sb.length()>0)
        tokens.add(sb.toString());

    return tokens;
}