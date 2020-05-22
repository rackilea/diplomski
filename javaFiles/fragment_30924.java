int length = value.length();
StringBuilder buffer = new StringBuilder(length);
boolean sentence = false;
boolean space = false;
for (int i = 0; i < length; i++) {
    char c = value.charAt(i);
    switch (c) {
        case ',' :
        case '.' :
        case '?' :
        case '!' :
            sentence = false;
            space = false;
            buffer.append(c);
            break;
        case ' ' :
            if (!space) {
                space = true;
                buffer.append(c);
            }
            break;
        case '\t' :
            space = false;
            buffer.append(c);
            break;
        default:
            if (sentence) {
                buffer.append(Character.toLowerCase(c));
            } else {
                buffer.append(Character.toUpperCase(c));
            }
            sentence = true;
            space = false;
    }
}
System.out.println(buffer);