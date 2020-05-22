public class JnaFanuc {

    public interface Fwlib32 extends Library {
        Fwlib32 INSTANCE = (Fwlib32) Native.load("Fwlib32", Fwlib32.class);

        short cnc_allclibhndl3(String ipaddr, short port, NativeLong timeout, short FlibHndl);
    }

    public static void main(String[] args) {
        ShortByReference handle = new ShortByReference();
        short ret;
        String ip = "192.168.1.100";
        short port = (short) 8193;
        NativeLong timeout = new NativeLong(10);
        Fwlib32 fwl = Fwlib32.INSTANCE;

        ret = fwl.cnc_allclibhndl3(ip, port, timeout, handle);

        System.out.println("cnc_allclibhndl3 Ret: " + ret);
        System.out.println("hndl: " + handle.getValue());
    }
}