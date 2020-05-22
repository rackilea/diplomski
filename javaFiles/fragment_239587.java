public void tokenize() throws IOException {
    BufferedReader reader = null;
    try {
        // attempt creating a reader for the input
        reader = this.newReader();
        ...
    }
    finally {
        if (reader != null) {
            try {
                reader.close();
            }
            catch (IOException e) {
                // nothing to do anymore: ignoring
            }
        }
    }
}