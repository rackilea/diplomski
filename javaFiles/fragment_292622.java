public class Foobar {

    public Foobar () {
        throw new RuntimeException();
    }

}

// Somewhere else ...
Mockito.mock(Foobar.class); // No exception will be thrown because constructor is never called