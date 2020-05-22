TreeMap<Double, Movie> movies = new TreeMap<>();
movies.put(0.6, new Movie("Movie A"));
movies.put(0.9, new Movie("Movie B")); // 0.6 + 0.3
movies.put(1.0, new Movie("Movie C")); // 0.6 + 0.3 + 0.1
Double probability = Math.random(); // between 0 (inclusive) and 1.0 (exclusive)
Movie chosen = movies.higherEntry(probability).getValue();