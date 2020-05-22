@Entity
public class TestClass {    
    @Id
    private long id;

    @OneToMany(mappedBy="testClass")
    private List<MatrixRow> matrix;
}