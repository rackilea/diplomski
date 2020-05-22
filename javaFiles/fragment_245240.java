public class Main {

    public enum IpHdrProtocol {

        TCP(6), SCTP(132), MPLS(137);
        int Value;

        IpHdrProtocol(int value) {
            Value = value;
        }
    }

    public static void main(String[] argv) throws NoSuchMethodException, IllegalArgumentException, InvocationTargetException,
            IllegalAccessException, SecurityException, NoSuchFieldException {
        System.err.println(getProtocol(6));
        System.err.println(getProtocol(132));
        System.err.println(getProtocol(137));
    }

    private static IpHdrProtocol getProtocol(int i) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
            SecurityException, NoSuchFieldException {
        Field f = IpHdrProtocol.class.getDeclaredField("Value");
        Method m = IpHdrProtocol.class.getMethod("values", null);
        Object[] invoke = (Object[]) m.invoke(null, null);
        for (Object o : invoke) {
            if (!f.isAccessible()) {
                f.setAccessible(true);
            }
            if (((Integer) f.get(o)).intValue() == i) {
                return (IpHdrProtocol) o;
            }
        }
        return null;
    }

    }