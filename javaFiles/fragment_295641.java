public static void main(String[] args) throws FileNotFoundException {
    File file = new File ("file.txt");
    file.getParentFile().mkdirs();
    try
    {
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println ("hello");
        printWriter.close();       
    }
    catch (FileNotFoundException ex)  
    {
        // insert code to run when exception occurs
    }
}