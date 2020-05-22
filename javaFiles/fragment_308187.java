import java.util.Objects;

public class BlogPostGroup {

    String titles;
    String author;
    String types;
    int likes;

    public BlogPostGroup(String titles, String author, String types, int likes) {
        this.titles = titles;
        this.author = author;
        this.types = types;
        this.likes = likes;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlogPostGroup that = (BlogPostGroup) o;
        return likes == that.likes &&
                Objects.equals(titles, that.titles) &&
                Objects.equals(author, that.author) &&
                Objects.equals(types, that.types);
    }

    @Override
    public int hashCode() {

        return Objects.hash(titles, author, types, likes);
    }

    @Override
    public String toString() {
        return "BlogPostGroup{" +
                "titles='" + titles + '\'' +
                ", author='" + author + '\'' +
                ", types='" + types + '\'' +
                ", likes=" + likes +
                '}';
    }
}