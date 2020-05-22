import java.util.List;
import java.util.ArrayList;

public final class Museum {

    private final List<ArtObject> artworks;

    public Museum() {
        this.artworks = new ArrayList<ArtObject>();
        artworks.add(new Painting("Mona Lisa"));
        artworks.add(new Drawing("Madame Palmyre with Her Dog"));
        artworks.add(new Painting("The Night Watch"));
    }

    public void printAllWorks() {
        for (final ArtObject work : this.artworks) {
            System.out.println(work);
        }
    }

    public void printAllPaintings() {
        final ArtVisitor paintingsPrinter = new ArtVisitor() {

            @Override
            public void visit(final Painting painting) {
                System.out.println(painting);
                // Note: We don't need any unsafe downcast here!
                painting.aMethodOnlyPaintingsHave();
            }
        };
        for (final ArtObject work : this.artworks) {
            work.takeVisitor(paintingsPrinter);
        }
    }

    public static void main(final String[] args) {
        final Museum myMuseum = new Museum();
        System.out.println("All ArtObjects:\n");
        myMuseum.printAllWorks();
        System.out.println("\n\nAll Paintings:\n");
        myMuseum.printAllPaintings();
    }
}