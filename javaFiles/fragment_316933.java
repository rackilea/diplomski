// obtain your file through some means
File file;
LSInput ls = null;

try {
    InputStream is = new FileInputStream(file);

    // obtain an LSInput object
    LSInput ls = getLSInput(is);
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (Exception e) {
    e.printStackTrace();
}

if (ls != null) {
    XMLSchemaLoader xsLoader = new XMLSchemaLoader();
    XSModel xsModel = xsLoader.load(ls);

    // now use your XSModel object here ...
}