import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FooBarBazTests extends TestCase {


    @Test
    public void testMyTemplateMethod() {
        List tracker = new ArrayList();
        SimpleFooBarBaz toTest = new SimpleFooBarBaz(tracker);

        toTest.myTemplateMethod();


        assertEquals("foo", tracker.get(0));

        // more assertions
    }


    @Test
    public void testMyTemplateMethodWithMockito() {
        FooBarBaz mocked = mock(FooBarBaz.class);

        mocked.myTemplateMethod();

        // times(1) is unnecessary, but explicit
        verify(mocked, times(1)).foo();
        verify(mocked, times(1)).bar();
        verify(mocked, times(1)).baz();
    }

    class SimpleFooBarBaz extends FooBarBaz {


        List tracker;

        SimpleFooBarBaz(List tracker) {
            this.tracker = tracker;
        }

        public void foo() {
            tracker.add("foo");
        }

        @Override
        public void bar() {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        @Override
        public void baz() {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        // others there

    }

}