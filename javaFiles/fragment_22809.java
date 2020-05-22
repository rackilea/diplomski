@Stateless
public class ItemsSession {
    @PersistenceContext(unitName ="officePU")
    private EntityManager em;
    // ... the rest of your code

    public String updateDocument(Integer id,InputStream is) throws SQLException{
        String msg = "";
        Documents docs = em.find(Documents.class, id); // fetch record from DB
        // Assuming your InputStream is a ByteArrayInputStream
        byte[] doc = new byte[is.available()]; // create target array
        is.read(doc, 0, doc.length);  // read bytes into byte array
        docs.setDoc(doc); // 

        return msg; // returning exception message from method call?????
    }
    ...
}