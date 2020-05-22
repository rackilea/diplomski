import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;

// Tell JUnit4 to run it as a parametrized test.
@RunWith(Parameterized.class)
public class MyInterfaceContractTest {

    private MyInterface _toTest;

    // Load the test data into your test instance via constructor
    public MyInterfaceContractTest(MyInterface impl) {
        this._toTest = impl;
    }

    // Supply the test data, in this example just the two implementations you want to test.
    @Parameterized.Parameters
    public static Collection<Object[]> generateData() {
        return Arrays.asList(new Object[]{new MyInterfaceImpl1()}, new Object[]{new MyInterfaceImpl2()});
    }

    @Test
    public void testContract(){
        // assert whatever, using your _toTest field
    }
}