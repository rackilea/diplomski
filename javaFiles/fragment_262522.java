import org.mockito.Mockito.*;

...

@Test
public void Test {
    Listener listener = mock(Listener.class);

    object.execute(listener);

    verify(listener).onExecuted();
}