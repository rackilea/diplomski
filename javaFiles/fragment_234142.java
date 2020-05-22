private static Classifier loadModel(File path, String name) throws Exception {

    Classifier classifier;

    FileInputStream fis = new FileInputStream(path + name + ".model");
    ObjectInputStream ois = new ObjectInputStream(fis);

    classifier = (Classifier) ois.readObject();
    ois.close();

    return classifier;
}