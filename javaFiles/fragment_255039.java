public static List<Movie> loadMovies() {

        // Initialize your movie list
        List<Movie> movieList = new ArrayList<>();

        String line = "", title, rating, synopsis, genre, director;
        int id, price, runtime, index = 0;
        String[] actors;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(movieIS))) {

            while ((line = br.readLine()) != null) {
                index++;
                String[] data = line.split("\\t");
                id = Integer.parseInt(data[0]);
                title = data[1];
                rating = data[2];
                synopsis = data[3];
                genre = data[4];
                director = data[5];
                actors = data[6].split(";");
                price = Integer.parseInt(data[7]);
                runtime = Integer.parseInt(data[8]);

                // Create your Movie object here,
                // note that I'm using constructor here,
                // You can also use setters for optional fields as well
                Movie movie = new Movie(id, title, rating, synopsis, genre, director, actors, price, runtime);

                movieList.add(movie);
            }
            String[] lines = new String[index];
            for (int i = 0; i < index; i++) {
                lines[i] = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //return movieList
        return movieList;
    }