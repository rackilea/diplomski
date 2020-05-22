import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;

import java.lang.reflect.Method;

import org.junit.Test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MockitoSpyTest {

    @Test
    public void execTest() {

        System.out.println("*** TEST 1 ***");
        System.out.println("Test on unmodified object");
        MySet ms = new MySetImpl();
        ms.set("test value");
        System.out.println("Set contains: " + ms.get());

        // decorate ms1 with easymock
        System.out.println("\n*** TEST 2 ***");
        MySet spyMs = spy(ms);
        doThrow(new NullPointerException("my test nullpointer")).when(spyMs).get();
        System.out.println("Test decorated object with SPY");
        spyMs.set("test value");
        try {
            System.out.println("Set contains: " + spyMs.get());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException - as expected");
        }

        // Enhance call with CGLIB
        System.out.println("\n*** TEST 3 ***");
        System.out.println("Test on CGLIB decorated object");
        Enhancer enc = new Enhancer();
        enc.setSuperclass(MySetImpl.class);
        enc.setInterfaces(new Class[] { MySet.class });
        enc.setCallback(new MethodInterceptor() {

            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                if ("get".equals(method.getName())) {
                    System.out.println("CGLIB decorated GET call");
                }
                return proxy.invokeSuper(obj, args);
            }
        });
        MySet ms1 = (MySet) enc.create();
        ms1.set("test value");
        System.out.println("Set contains: " + ms1.get());

        // decorate ms1 with easymock
        System.out.println("\n*** TEST 4 ***");
        System.out.println("Test on CGLIB decorated object with SPY");
        MySet spyMs1 = spy(ms1);
        doThrow(new NullPointerException("my test nullpointer")).when(spyMs1).get();
        spyMs1.set("test value");
        System.out.println("Set contains: " + spyMs1.get());
    }

    public interface MySet {
        void set(String val);

        String get();
    }

    public static class MySetImpl implements MySet {
        String val;

        public void set(String val) {
            this.val = val;
            System.out.println("Original SET call:" + val);
        }

        public String get() {

            System.out.println("Original GET call:" + val);
            return val;
        }

    }
}