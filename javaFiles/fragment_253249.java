@Entity
@Table(name="Lokal")
@SecondaryTable(name = "Ocena", pkJoinColumns=@PrimaryKeyJoinColumn(name="idOcena"))
public class Lokal {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idLokal")
    private int id; 
    @Column(table="Ocena" ,name="rating")
    private int rating;

    //--Getters and Setters skipped--//

}