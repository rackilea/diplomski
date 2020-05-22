@Test
public void testExecute_AsyncExample2() throws Throwable {

    MovieListLoaderWorker mlw = new MovieListLoaderWorker(db, response);    
    mlw.execute();

    mlw.get();  //blocking so we can verify

    verify(response).started();
    verify(db).getMovieSet(true);
}