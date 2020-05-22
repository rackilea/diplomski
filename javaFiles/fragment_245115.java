import lotus.domino.AgentBase;
import com.ibm.commons.util.io.base64.Base64;
import java.lang.reflect.Method;

public class JavaAgent extends AgentBase {

    public void NotesMain() {

        try {
            // trucated DXL string
            String dataDXL = "YQAYAAAAAACqAgAAAQAAAAAAAAAAAAAAYAC8AgAAqgKqAgAAAAAAAAAAyv66vgAAADEALwcAAgEAFWNoL2hhc3NlbGJhL3hwYWdlcy9aWgcA";

            // base64 decode the string
            String b64 = Base64.decode(dataDXL);
            byte[] b64Bytes = b64.getBytes();
            byte[] classBytes = new byte[b64Bytes.length - 42];

            // skip the first 42 bytes
            System.arraycopy( b64Bytes, 42, classBytes, 0, b64Bytes.length - 42);

            try {
                // load the class
                ByteClassLoader obj = new ByteClassLoader();
                Class theClass = obj.findClass("ch.hasselba.demo.LoadedClass", classBytes);
                // instantiate it
                Object theInstance = theClass.newInstance();

                // get the method printTime via Reflection & call it
                Method theMethod = theInstance.getClass().getMethod("printTime", null);
                theMethod.invoke( theInstance, null);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    // the class loader
    public static class ByteClassLoader extends ClassLoader {

        public Class findClass(String name, byte[] data) {
            return defineClass(name, data, 0, data.length);
        }
    }
}