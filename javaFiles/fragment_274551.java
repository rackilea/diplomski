@Document(collection = "rule_tables")
public class TableRaw {

  @Id
  private String _id;
  private String key;
  private String name;
  private String returns;
  private ArrayList<AxisRaw> axis;

  private List<List<Integer>> values; // no initialization.
}