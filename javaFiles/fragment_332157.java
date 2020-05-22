@SuppressWarnings("unchecked")
public static ArrayList<String> deserialise() {

    // Do not create a new ArrayList, you get
    // it from "readObject()", otherwise you just
    // overwrite it.
    ArrayList<String> words = null;
    File serial = new File("serialise.bin");

    try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(serial))) { 
        // Cast from "Object" to "ArrayList<String>", mandatory
        words = (ArrayList<String>) in.readObject();
    } catch(Exception e) {
        e.printStackTrace();
    }

    return words;
}