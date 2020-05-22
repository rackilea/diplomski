public boolean xyzThere(String str) {
    int index = str.indexOf(".xyz");
    if(index >= 0) {
        return xyzThere(str.substring(0, index)) || xyzThere(str.substring(index + 4));
    } else return (str.contains("xyz"));
}