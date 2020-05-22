File writeFile;
    Writer writer = null;

    writeFile = new File("D:\\note.txt");
    try {
        writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(writeFile), "utf-8"));
        jTextArea1.write(writer);
    } catch (IOException ex) {
        // report
    } finally {
        try {
            writer.close();
        } catch (Exception ex) {/*ignore*/
        }
    }