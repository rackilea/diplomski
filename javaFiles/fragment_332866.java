package test.moxy;

import java.util.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MoviesAdapter extends XmlAdapter<MoviesAdapter.Movies, Iterable<Movie>> {

    public static class Movies {
        public List<Movie> movie = new ArrayList<Movie>();
    }

    @Override
    public Iterable<Movie> unmarshal(Movies v) throws Exception {
        return v.movie;
    }

    @Override
    public Movies marshal(Iterable<Movie> v) throws Exception {
        Movies movies = new Movies();
        for(Movie movie : v) {
            movies.movie.add(movie);
        }
        return movies;
    }

}