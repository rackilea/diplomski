public class Test {
    public static class MoviesResponse{
        public static class Movie{
            public String id;
            public String title;
            public String year;
        }

        public int total;
        public List<Movie> movies = new ArrayList<>();

        public static MoviesResponse fetch(int page){
            try {
                String request = "http://api.rottentomatoes.com/api/public/v1.0/lists/movies/in_theaters.json?page_limit=16&page=" +
                    page +
                    "&country=us&apikey=cj5a4purh8fxgcmrtn95gheu";

                HttpClient httpClient = new DefaultHttpClient();

                HttpGet httpget = new HttpGet(request);

                HttpResponse response = httpClient.execute(httpget);

                BufferedReader rd = new BufferedReader
                    (new InputStreamReader(response.getEntity().getContent()));

                String line = "";

                StringBuilder textView = new StringBuilder();
                while ((line = rd.readLine()) != null) {
                    textView.append(line);
                    //  System.out.println(textView);
                }

                String resp = textView.toString();

                ObjectMapper mapper = new ObjectMapper();

                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

                return mapper.readValue(resp, MoviesResponse.class);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        int numberOfSimultaneousThreads = 3;

        ExecutorService service = Executors.newFixedThreadPool(numberOfSimultaneousThreads);

        MoviesResponse firstPage = MoviesResponse.fetch(1);

        System.out.println("firstPage.total = " + firstPage.total);

        int pageCount = 3; //update it with formula based on firstPage.total and pageSize (i.e. firstPage.total / pageSize + 1)

        List<Callable<MoviesResponse>> jobs = new ArrayList<>();

        for(int i = 2;i <= pageCount;i++){
            final int page = i;
            jobs.add(new Callable<MoviesResponse>() {
                @Override
                public MoviesResponse call() throws Exception {
                    return MoviesResponse.fetch(page);
                }
            });
        }

        List<Future<MoviesResponse>> results = service.invokeAll(jobs, 2, TimeUnit.MINUTES);

        for (Future<MoviesResponse> result : results) {
            for (MoviesResponse.Movie movie : result.get().movies) {
                System.out.println(movie.title + " (" + movie.year + ")");
            }
        }

        service.shutdown();
    }
}