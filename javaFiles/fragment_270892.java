String readNP() throws IOException{
//  ask about file name
    for (;;) {
        System.out.print("file name ");
        String filename;
        filename = sysin.readLine();
        File f = new File(filename);
        if (f.exists() && !f.isDirectory()) return filename.trim();
        System.out.println("file absent");  //message if the there is no file with this name
    }
}