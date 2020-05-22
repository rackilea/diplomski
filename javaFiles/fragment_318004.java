if (newchar == letter) {
    int index1 = text.lastIndexOf(' ',i);
    int index2 = text.indexOf(' ',i);
    // TODO -- handle when index1 or index2 is < 0;  that means it wasn't found, 
    //  and you should use the string boundary (0 or length()) instead.
    String word = text.substring( index2,index1);
    result += "\n" + word;
}