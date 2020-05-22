public void writeToFile(String fileName, String contents, int mode) throws IOException {
    FileOutputStream fout = openFileOutput(fileName, mode);
    OutputStreamWriter osw = new OutputStreamWriter(fout);
    osw.write(contents);
    osw.flush();
    osw.close();
}