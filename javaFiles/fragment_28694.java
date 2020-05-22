class ZipCompress {
    public static void main(String[] args) throws IOException {

        String dir = "d:\\My folder\\";
        // this entries I want to put in archives in the way they are now
        String[] entries = { "temp\\folder1\\file1.txt", "temp\\folder2\\file2.txt",
                "temp\\file3.txt" };

        ZipOutputStream zipos = new ZipOutputStream(new BufferedOutputStream(
                new FileOutputStream(dir + "archive.zip")));

        // time to create entries and fill them with data
        for (String entrie : entries) {
            System.out.println("Writing file: " + dir + entrie);

            // prepering file stream
            BufferedInputStream fileStream = new BufferedInputStream(
                    new FileInputStream(dir + entrie));

//--------------------------------------------------------------------------
//          Here we decide how we entry will look like in archive.
//          We use only part of path from String[] entries
//          like "temp\\folder1\\file1.txt"
//--------------------------------------------------------------------------
            ZipEntry newEntry = new ZipEntry(entrie);

            newEntry.setComment("comment to entry: " + newEntry);

            // now lets put this entry in archive
            zipos.putNextEntry(newEntry);

            // lets put data from file to current archive entry
            int c;
            while ((c = fileStream.read()) != -1)
                zipos.write(c);
            fileStream.close();
        }
        zipos.close();
    }
}