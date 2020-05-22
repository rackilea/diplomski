@Embeddable
@CsvDataType
public class TestClass1 implements Serializable {

private static final long serialVersionUID = 371968159365574089L;

@CsvField(pos = 1)
private int id;

@CsvField(pos = 2)
private String Name;

// getter setter methods
}