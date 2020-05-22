@Entity
public class Book implements Identifiable<Long> {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Book))
            return false;

        Book other = (Book) o;

        return id != null &&
               id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }

    //Getters and setters omitted for brevity
}