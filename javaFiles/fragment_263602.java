public void filterInformationFromGoogleMovies(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //URL Data
        final String API_URL1 = "http://google.com/movies?near=";
        String location = "Chicago";
        String completeURL = API_URL1 + location;


        ArrayList<Theater> _theaters = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(completeURL).get();
            Elements theaters = doc.select("div.theater");
            for (int i = 0; i < theaters.size(); i++) {
                String title, length, showtimes, name, info;
                ArrayList<Movie> _movies = new ArrayList<Movie>();

                name = theaters.get(i).getElementsByClass("name").get(0).text();
                info = theaters.get(i).getElementsByClass("info").get(0).text();

                for (int j = 0; j < theaters.get(i).getElementsByClass("movie").size(); j++) {
                    title = theaters.get(i).getElementsByClass("movie").get(j).getElementsByClass("name").get(0).text();
                    length = theaters.get(i).getElementsByClass("movie").get(j).getElementsByClass("info").get(0).text();
                    showtimes = theaters.get(i).getElementsByClass("movie").get(j).getElementsByClass("times").get(0).text();
                    _movies.add(new Movie(title, length, showtimes));
                }

                _theaters.add(new Theater(name, info, _movies));
                Log.e("TEST", _theaters.get(i).toString() + "\n");
            }

        } catch (Exception e) {
            Log.e("TEST", e.getLocalizedMessage());
        }
    }

    class Movie {
        public Movie(String title, String length, String showtimes) {
            this.title = title;
            this.length = length;
            this.showtimes = showtimes;
        }

        public String title;
        public String length;
        public String showtimes;

        @Override
        public String toString() {
            return title + "\n" + length + "\n" + showtimes + "\n";
        }
    }

    class Theater {
        public Theater(String name, String info, ArrayList<Movie> movies) {
            this.name = name;
            this.info = info;
            this.movies = movies;
        }

        public String name;
        public String info;
        public ArrayList<Movie> movies;

        @Override
        public String toString() {
            return name + "\n" + info + "\n   Movies:" + "\n" + movies.toString();
        }
    }