public class Table<Column extends Enum<Column> & Table.Columns> {
  // Name of the table.
  protected final String tableName;
  // All of the columns in the table. This is actually an EnumSet so very efficient.
  protected final Set<Column> columns;

  /**
   * The base interface for all Column enums.
   */
  public interface Columns {
    // What type does it have in the database?
    public Type getType();
  }

  // Small list of database types.
  public enum Type {
    String, Number, Date;
  }

  public Table(String tableName,
               Set<Column> columns) {
    this.tableName = tableName;
    this.columns = columns;
  }
}