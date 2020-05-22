@Entity
@Table
public class SingleDate {
    @Id
    private int id;
    private Date date;

    @Basic
    @Column(name = "DATE")
    public Date getDate() {
        return date;
    }
}