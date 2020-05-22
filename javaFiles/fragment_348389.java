//here's the Waiter import, among others that you'll need
import net.jodah.concurrentunit.Waiter;

@Test
public void testExecute_AsyncExample1() throws Throwable {

    final Waiter waiter = new Waiter();

    MovieListLoaderWorker mlw = new MovieListLoaderWorker(db, new Response() {

        @Override
        public void success(ArrayList<String> movieList) {
            waiter.assertNotNull(movieList);
            waiter.assertTrue(movieList instanceof ArrayList);
            waiter.assertEquals(3, movieList.size());
            waiter.resume();
        }

        @Override
        public void started() {                             
        }

        @Override
        public void failure(BackgroundException ex) {               
        }

        @Override
        public void statusUpdate(ArrayList<String> list) {              
        }
    });

    mlw.execute();

    waiter.await(1, TimeUnit.SECONDS);      
}