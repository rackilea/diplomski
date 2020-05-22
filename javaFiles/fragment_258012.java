} finally {
    try {
        inputFile.delete();
        reader.close();
        writer.close();
        inputFile.delete();
        boolean successful = tempFile.renameTo(inputFile);
        System.out.println(successful);
    } catch (IOException ex) {
           ex.printStackTrace();
    }

}