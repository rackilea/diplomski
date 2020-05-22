public class VersionTable extends Table<VersionTable.Column> {
  public enum Column implements Table.Columns {
    Version(Table.Type.String),
    ReleaseDate(Table.Type.Date);
    final Table.Type type;

    Column(Table.Type type) {
      this.type = type;
    }

    @Override
    public Type getType() {
      return type;
    }
  }

  public VersionTable() {
    super("Versions", EnumSet.allOf(Column.class));
  }
}