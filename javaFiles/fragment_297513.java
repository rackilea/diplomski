try {
    File exportDir = new File(myDir + "/text/", filename);
    if (exportDir .getParentFile().mkdirs()) {
        exportDir .createNewFile();
        FileOutputStream fos = new FileOutputStream(exportDir );

        fos.write(outputString.getBytes());
        fos.flush();
        fos.close();
    }
} catch (Exception e) {
    e.printStackTrace();
}