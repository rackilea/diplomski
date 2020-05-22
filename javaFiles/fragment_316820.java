public class SerializableAdapter extends XmlAdapter<String, Serializable>>{

    private static final String NULL = "'NULL'"; // Will never collide, since it has 's

    @Override
    public Serializable unmarshal(String e) throws Exception {
        if (e == NULL) {
            return null;
        }
        byte [] eB = e.getBytes("ISO-8859-1");
        InputStream iS = new ByteArrayInputStream(Base64.getDecoder().decode(eB));
        ObjectInputStream oIS = new ObjectInputStream(iS);
        return (Serializable) oIS.readObject();
    }

    @Override
    public String marshal(Serializable o) throws Exception {
        if (o == null) {
            return NULL;
        }
        ByteArrayOutputStream bAOS = new ByteArrayOutputStream();
        ObjectOutputStream oOS = new ObjectOutputStream(bAOS);
        oOS.writeObject(o);
        return Base64.getEncoder().encodeToString(bAOS.toByteArray());
    }

}