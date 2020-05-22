String line, filepath = "/file.xml";
    long ptr;

    try (RandomAccessFile file = new RandomAccessFile(filepath, "rw");) {

        //captures the XML declaration
        Pattern p = Pattern
                .compile("<\\?xml([^<>]*)version=\"(1.[01])\"([^<>]*)>");

        //sets ptr to the beginning of a file
        ptr = file.getFilePointer();


        while ((line = file.readLine()) != null) {
            Matcher m = p.matcher(line);

            //if the xml declaration has been found
            if (m.find()) {
                String newLine = line.replace("version=\"1.0\"", "version=\"1.1\"");        
                file.seek(ptr);
                file.write(newLine.getBytes());
                break;
            }
            ptr = file.getFilePointer();
        }

    } catch (IOException ex) {

    }


}