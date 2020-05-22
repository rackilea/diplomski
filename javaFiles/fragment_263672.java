@Entity
public class MatrixRow {
    @Id
    private long id;

    @ManyToOne
    private TestClass testClass;

    @CollectionOfElements
    private List<BigDecimal> row;
}