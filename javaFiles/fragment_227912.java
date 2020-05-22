@Rule
public Stopwatch stopwatch = new Stopwatch() {};

@Test
public void test_sleep_1_seconds()  {
    sleep1();
    assertTrue(stopwatch.runtime(TimeUnit.SECONDS) > 1);
}