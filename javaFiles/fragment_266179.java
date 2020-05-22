public class MClass {

    public String getSysTime() { // this is the tricky one
        return "salala";
    }
}

public class MTest {

    @Test
    public void testSpying() {
        MClass m = Mockito.spy(new MClass());
        Mockito.when(m.getSysTime()).thenReturn("FakeTimestamp");
    }
}