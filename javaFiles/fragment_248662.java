public String encodeRotation(String txt, int distance) {
    int first = ' ', last = 128, range = last - first;
    while(distance<0) distance+=range;
    if(distance == 0) return txt;
    char[] buffer = txt.toCharArray();
    for (int i = 0; i < txt.length(); i++) {
        char c = buffer[i];
        if(c<first || c>=last)
            throw new IllegalArgumentException("unsupported character "+c);
        buffer[i] = (char) ((c - first + distance) % range + first);
    }
    return String.valueOf(buffer);
}

public String decodeRotation(String txt, int key) {
    return encodeRotation(txt, -key);
}