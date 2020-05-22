void append(String s) {
    buffer.append(s);
    if(buffer.length() > MAX_LENGTH){
        buffer.delete(0, buffer.length() - MAX_LENGTH);
    }
}