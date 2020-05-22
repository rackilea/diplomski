FileReader inputStream = null;
FileWriter outputStream = null;

try {
    inputStream =
        new FileReader("inputfile.txt");
    outputStream =
        new FileWriter("outputfile.txt");

    int c;
    int counter = 1;
    while ((c = inputStream.read()) != -1) {
        //keep a counter that will cycle for 12 characters
        //check if c represents a alphabet or number, write it to file else skip 
        //when counter is 12 write a newline
        outputStream.write(c);
    }
} finally {
    if (inputStream != null) {
        inputStream.close();
    }
    if (outputStream != null) {
        outputStream.close();
    }
}