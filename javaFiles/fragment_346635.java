Class TestArtistList{
public class ArtistList{
    // TODO declare the fields with getters and setters and the methods
}
public static void main(String[] args) {
    // TODO your test code

    ArrayList<ArtistList> artists = new ArrayList<ArtistList>();

    artists.add(new ArtistList("Dave Matthews Band", "Under The Table and Dreaming", "1994", 12.12));
    artists.add(new ArtistList("Stone Temple Pilots", "Core", "1992", 5.99));
    artists.add(new ArtistList("Incubus", "Make Yourself", "1999", 5.89));
    size = artists.size();
    System.out.println("We have " + size + " artists");

    for (ArtistList out : artists) {
        System.out.println(out);
    }

    for (@SuppressWarnings("unused") ArtistList out : artists) {
        out.priceOut = priceTotal(out.price);
    }
}
}