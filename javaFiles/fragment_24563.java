private static FileResourceManager frm;
    public void writeOut(E event) throws IOException {
        ...

        if (frm == null) {
            frm = new FileResourceManager(fileName, tempDir, false, loggerFacade);
        }

        Object txId = null;
        try {
...
        }

        catch (Exception e) {
...
}
    }