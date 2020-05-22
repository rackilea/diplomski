f1 = new File("sink.txt");
try (FileWriter fw = new FileWriter(f1)) {

   // compute stuff

   // write stuff to file

} catch (FileNotFoundException ex) {
    System.out.println(ex.getMessage());
} catch (IOException ex) {
    // This is ugly for a real app.  However, an IOException that
    // is not a FileNotFoundException is "unexpected" at this point
    // and providing a user-friendly explanation would be tricky. 
    ex.printStackTrace();  
}