public String repeatSeparator(String word, String sep, int count) {    
    StringBuffer buffer = new StringBuffer();

    while (count > 0) {
        buffer.append(word);
        count--;
        if (count > 0) {
            buffer.append(sep);
        }
    }

    return buffer.toString();                           
}