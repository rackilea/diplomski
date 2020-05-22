public static void main(String[] args) {
    String filepath = "Student_Database.txt";
    String temppath = "temp.txt";
    File oldfile = new File(filepath);
    File newfile = new File(temppath);

    assert (oldfile.exists());

    try (
       PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(newfile, true)));
       Scanner x = new Scanner(oldfile)
    ) {

        x.useDelimiter("[,\n]");

        int id = 0;
        while (x.hasNext())  {
            id = x.nextInt();
            pw.print(id + "\n");
        }

        pw.print(++id + "\n");

        // If you put the move here, it will fail as there 
        // are still active handles on the files.
    } catch (IOException e) {

       // add some logging 

    } // <--- this bracket is important, the move must be below.

    // At this point the try-with-resources guarantess 
    // that all previous openened handles (defined in the try-with) have been closed.

    // do move operation here
    try {
        Files.move(newfile.toPath(), oldfile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
       // add some more logging 
    }
}