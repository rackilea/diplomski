interface DateTime {
    Date getDate();
}

class DateTimeImpl implements DateTime {
    @Override
    public Date getDate() {
       return new Date();
    }
}

class MyClass {

    private final DateTime dateTime;
    // inject your Mock DateTime when testing other wise inject DateTimeImpl

    public MyClass(final DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public long getDoubleTime(){
        return dateTime.getDate().getTime()*2;
    }
}

public class MyClassTest {
    private MyClass myClassTest;

    @Before
    public void setUp() {
        final Date date = Mockito.mock(Date.class);
        Mockito.when(date.getTime()).thenReturn(30L);

        final DateTime dt = Mockito.mock(DateTime.class);
        Mockito.when(dt.getDate()).thenReturn(date);

        myClassTest = new MyClass(dt);
    }

    @Test
    public void someTest() {
        final long doubleTime = myClassTest.getDoubleTime();
        assertEquals(60, doubleTime);
    }
}