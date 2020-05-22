public static void main(String[] args) throws Exception {

        File file = new File("src/file.txt");
        File tmpFile = new File("src/tmpFile.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tmpFile));

        try{
                writer.write("HALLO" + "\n");
        }
        finally {
            writer.close();
            reader.close();
        }

        file.delete();
        tmpFile.renameTo(file);

    /*File oldFile = new File("tmpFile.txt");
    File newFile = new File(oldFile.getParent(), "file.txt");
    Files.move(oldFile.toPath(), newFile.toPath());*/
}