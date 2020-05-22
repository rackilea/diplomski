import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.junit.Test;
import static org.junit.Assert.*;

public class CowSSCCE {

    public interface Bean {

        public String getName();

        public void setName(String name);

        public Object clone();

    }

    public class BeanImpl implements Bean {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object clone() {
            BeanImpl copy = new BeanImpl();
            copy.name = new String(name);
            return copy;
        }

    }

    public class COWInvocationHandler implements InvocationHandler {

        private Bean instance;

        private boolean copy = false;

        public COWInvocationHandler(Bean instance) {
            this.instance = instance;
        }

        public Object invoke(Object proxy, Method method, Object[] args)
                throws Throwable {

            // copy only on the first setter call.
            if (!copy && method.getName().startsWith("set")) {
                instance = (Bean) instance.clone();
                copy = true;

            }

            return method.invoke(instance, args);
        }

    }

    @Test
    public void testCOW() {
        Bean original = new BeanImpl();
        original.setName("original");

        Bean reference = (Bean) Proxy.newProxyInstance(
                Bean.class.getClassLoader(), new Class[] { Bean.class },
                new COWInvocationHandler(original));

        // no write access, reference is pointing to the original instance
        assertEquals(original.getName(), reference.getName());
        assertEquals(original.toString(), reference.toString());

        // write access, reference is a copied instance
        reference.setName("reference");
        assertEquals("reference", reference.getName());
        assertNotEquals(original.getName(), reference.getName());
        assertNotEquals(original.toString(), reference.toString());
    }

}