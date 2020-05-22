@Embeddable
@CsvDataType
public class TestClass2 implements Serializable {

private static final long serialVersionUID = 371968159365574089L;

@CsvField(pos = 3)
private int orderno;

@CsvField(pos = 4)
private String orderName;

// getter setter methods
}