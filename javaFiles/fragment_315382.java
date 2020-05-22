public class MyClass {

    private Executor executor = new SyncTaskExector();
    private ClassToBeCalled classToBeCalled;

    private MyClass myClass;

    @Before
    public setup() {
       myClass = new MyClass();
       classToBeCalled = mock(ClassToBeCalled.class);
       RelfectionTestUtils.setField(myClass, "executor", executor);
       RelfectionTestUtils.setField(myClass, "classToBeCalled", classToBeCalled);
    }

    @Test
    public void entryListenerShouldInvokeTheClassToBeCalled(){
        // given
        EntryEvent entryEvent = mock(EntryEvent.class);
        MyEntry value = mock(MyEntry.class);
        when(entryEvent.getValue()).thenReturn(value);

        // when
        myClass.entryAdded(entryEvent);

        // then
        verify(classToBeCalled, times(1)).methodToBeCalled(value);
    }
}