for(char c : builder.toString().toCharArray()) {
    String s = String.valueOf(c);

    if(Pattern.matches("<|>|-|-?\\d+", s)){
        szBuffer += s;
    }
}