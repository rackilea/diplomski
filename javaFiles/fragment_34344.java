public class Foo implements Serializable {

    private static final long serialVersionUID = 20130605L;

    private Object fields[]; // So we can read it in old saved version.

    private String field1;
    private String field2;
    private Boolean fiedl3;

    // Methods, etc.

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {


        in.defaultReadObject();


        if (fields != null) {
            // If we have read an old version.
            field1 = (String)fields[0];
            field2 = (String)fields[1];
            field3 = (Boolean)fields[2];
            // ....

            // We set fields to null so no more space is waste than necessary.
            fields = null;
        }

    }
}