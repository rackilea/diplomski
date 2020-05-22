public class PojoSurrogate implements Serializable {

    private String foo;

    public PojoSurrogate(Pojo pojo) {
        this.foo = pojo.getMsg();
    }   

    private Object readResolve() throws ObjectStreamException {
        return new Pojo(foo);
    } 
}