import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Foo {

    @Embeddable
    public static class Id implements Serializable {
        @Column(name = "bar_id_col")
        private Long barId;

        @Column(name = "i_col")
        private int i;

        public Id() {
        }

        public Id(Long barId, int i) {
            this.barId = barId;
            this.i = i;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Id)) {
                return false;
            }

            final Id id = (Id) o;

            if (i != id.i) {
                return false;
            }
            if (barId != null ? !barId.equals(id.barId) : id.barId != null) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            int result = barId != null ? barId.hashCode() : 0;
            result = 31 * result + i;
            return result;
        }
    }

    @EmbeddedId
    private Id id = new Id();

    @ManyToOne
    @JoinColumn(name = "bar_id_col", insertable = false, updatable = false)
    private Bar bar;

    private int i;

    public Foo() {
    }

    public Foo(Bar bar, int i) {
        // set fields
        this.Bar = bar;
        this.i=i;
        // set identifier values
        this.id.barId = bar.getId();
        this.id.i = i;
    }

}