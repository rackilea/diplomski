c = s.toCharArray();
for(int i = c.length-1; i >= 0; i--) {
    if(c[i] == '+') {
        return format(s.substring(0, i)) + format(s.substring(i+1, s.length()));
    } else if(c[i] == '-') {
        return format(s.substring(0, i)) - format(s.substring(i+1, s.length()));
    }
}