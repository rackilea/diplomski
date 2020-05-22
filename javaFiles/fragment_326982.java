@Test
public void testWhatever (@Mocked final Session s)
{
    final Whatever w = new Whatever();
    w.method();

    new Verifications() {{ s.stop(); times = 0; }};
}