@Test
public class WaiterTest {
  @Test
  public void shouldSupportMultipleThreads() throws Throwable {
    final Waiter waiter = new Waiter();

    for (int i = 0; i < 5; i++)
      new Thread(new Runnable() {
        public void run() {
          waiter.assertTrue(true);
          waiter.resume();
        }
      }).start();

    waiter.await(0);
  }