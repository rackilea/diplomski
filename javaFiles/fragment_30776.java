public void writeString(String s) {
    try {
        out.println(s);
    } catch(IOException ex) {
    }
}