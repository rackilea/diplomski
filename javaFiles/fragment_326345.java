for (char c : s.toCharArray()) {
    c = (capNext)
            ?  ( (c>='a'&&c<='z') ? c+32 : c) //to Upper Case
            :  ( (c>='A'&&c<='Z') ? c-32 : c) //to Lower Case
    sb.append(c);
    capNext = (ACTIONABLE_DELIMITERS.indexOf((int) c) >= 0); // explicit cast not needed
}