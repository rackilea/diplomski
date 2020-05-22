StringBuilder sb = new StringBuilder(str);
for (int i = 0; i < str.length(); i++) {
    if (str.charAt(i) == 'Q') {
        sb.setCharAt(i, '1');
    } else if (str.charAt(i) == '1') {
        sb.setCharAt(i, 'Q');
    } 
}
return sb.toString();