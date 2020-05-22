try {
    int index = 100;
    raf.seek(index); //index = 100
    int counter = 0;
    int length = 400;
    while (counter < length) { //want to read the characters 400 times
       char c = (char) raf.read();
       if (!(c == '\n')) {   //don't append the newline character to my result
           sb.append(c);    //sb is a StringBuilder
           counter++;
       }
    }
} catch (IOException e) {
    e.printStackTrace();
}