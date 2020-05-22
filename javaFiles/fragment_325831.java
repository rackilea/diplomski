public abstract class Media {
    protected Date createdOn;
    protected String name;

    protected Date getCreationDate() {
        return createdOn;
    }

    public String getName() {
        return name;
    }

    public static void sort(List<Media> movieItems) {
        movieItems.sort(Comparator.comparing(Media::getCreationDate));
    }
}