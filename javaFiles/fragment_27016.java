char[] str = input.toCharArray();

    for(int i=str.length-1; i>=1; --i) {
        char c = str[i];
        char p = str[i-1];
        if (c == Character.toLowerCase(c) && p == Character.toUpperCase(p)){
            if (Character.toLowerCase(p) == c)
                return i-1;
        }
    }
    return -1;