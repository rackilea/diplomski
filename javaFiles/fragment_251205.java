String[] prod = { "pr", "od" };
    String[] cant = { "10.0", "20.0" };
    String[] pret = { "30.0", "40.0" };
    String[] storeAllArrays[] = {prod, cant, pret};

    Logger logger = Logger.getLogger(SerializerSample.class.getName());
    String serializedPath = "/tmp/store_test.ser";

    ObjectOutputStream out;
    try {
        out = new ObjectOutputStream(new FileOutputStream(serializedPath));
        out.writeObject(storeAllArrays);
        out.flush();
        out.close();
    } catch (FileNotFoundException ex) {
        logger.log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        logger.log(Level.SEVERE, null, ex);
    }

    try {
        InputStream file = new FileInputStream(serializedPath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        String[] storeAllArraysREAD[] = (String[][]) input.readObject();
        logger.log(Level.INFO, storeAllArraysREAD.toString());

    } catch (ClassNotFoundException ex) {
        logger.log(Level.SEVERE, "Cannot perform input. Class not found.",
                ex);
    } catch (IOException ex) {
        logger.log(Level.SEVERE, "Cannot perform input.", ex);
    }