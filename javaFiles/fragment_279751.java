registerHibernateType(Types.LONGVARCHAR, TextType.INSTANCE.getName());

public class MySQLDialect extends MySQLDialect {
  public AGOSQLServerDialect() {
    super();
    registerHibernateType(Types.LONGVARCHAR, TextType.INSTANCE.getName());
  }
}