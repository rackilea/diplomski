List<Object> results = new ArrayList<Object>();
FileInputStream fis = new FileInputStream("cool_file.tmp");
ObjectInputStream ois = new ObjectInputStream(fis);

try {
    while (true) {
        results.add(ois.readObject());
    }
} catch (OptionalDataException e) {
    if (!e.eof) 
        throw e;
} finally {
    ois.close();
}