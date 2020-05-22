public class SerialTest {
    private static class A implements Serializable {
        private static final long serialVersionUID = 1L;
    }

    private static class B implements Serializable {
    }

    public static void main(String[] args) throws Exception {
        System.out.println("A : " + containSerialVersionUID(A.class));
        System.out.println("B : " + containSerialVersionUID(B.class));
    }

    private static boolean containSerialVersionUID(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals("serialVersionUID")
                && field.getType() == Long.TYPE
                && Modifier.isPrivate(field.getModifiers())
                && Modifier.isStatic(field.getModifiers())
                && Modifier.isFinal(field.getModifiers())) {
                return true;
            }
        }
        return false;
    }
}