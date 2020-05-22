public class FieldSize {
    static final int BOOLEAN_SIZE = 1; // adjust to your storage method
    static final int REF_SIZE = 2;     // dito
    private static int getSize(Field f, Object o) {
        try {
        return f.getType().isPrimitive()? f.getType()==boolean.class? BOOLEAN_SIZE:
               f.get(o).getClass().getField("BYTES").getInt(null): REF_SIZE;
        } catch(ReflectiveOperationException ex) {
            throw new AssertionError(ex);
        }
    }
    boolean z;
    byte b;
    short s;
    char c;
    int i;
    long l;
    float f;
    double d;
    String str;

    public static void main(String[] args) {
        System.out.println("total: "+calculateSize(new FieldSize())+" size");
    }
    static int calculateSize(Object o) {
        int total=0;
        for(Class cl=o.getClass(); cl!=null; cl=cl.getSuperclass()) {
            for(Field f: cl.getDeclaredFields()) {
                if(Modifier.isStatic(f.getModifiers())) continue;
                int size=getSize(f, o);
                System.out.println(f.getName()+" ("+f.getType()+"): "+size);
                total+=size;
            }
        }
        return total;
    }
}