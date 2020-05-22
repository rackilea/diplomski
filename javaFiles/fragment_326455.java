public class SomeClass implements Serializable {
    private String fld1;
    private int fld2;
    private transient String fld3; 
    private void readObject(java.io.ObjectInputStream stream)
         throws IOException, ClassNotFoundException {
         stream.defaultReadObject(); //fills fld1 and fld2;
         fld3 = Configuration.getFooConfigValue();
    }
]