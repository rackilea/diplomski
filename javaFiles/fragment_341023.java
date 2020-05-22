import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.Map.Entry;
import static java.util.stream.Collectors.*;

public class SO {

    public static void main(String... args) {

        List<Album> albums = asList(
                new Album(
                        asList(
                                new Artist("bob"),
                                new Artist("tom")
                        )
                ),
                new Album(asList(new Artist("bill")))
        );

        Map<Artist, List<Album>> x = albums.stream()
                .flatMap(album -> album.getArtist().stream().map(artist -> pair(artist, album)))
                .collect(groupingBy(Entry::getKey, mapping(Entry::getValue, toList())));

        x.entrySet().stream().forEach(System.out::println);
    }

    static class Artist {
        private final String name;

        Artist(String name) {
            this.name = name;
        }

        public String toString() {return name;}

    }

    static class Album {
        private List<Artist> artist;

        Album(List<Artist> artist) {
            this.artist = artist;
        }

        List<Artist> getArtist() {
            return artist;
        }

    }

    private static <T,U> AbstractMap.SimpleEntry<T,U> pair(T t, U u) {
        return new AbstractMap.SimpleEntry<T,U>(t,u);
    }


}