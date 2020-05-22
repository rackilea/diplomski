public static class Session { public void stop() {} }
public static class Whatever {
    Session s = new Session();
    public synchronized void method() { s.stop(); }
}

@Test
public void testWhatever ()
{
    new Expectations() {
        @Mocked Session s;
        { s.stop(); times = 0; }
    };

    final Whatever w = new Whatever();
    w.method();
}