public class CustomMySQLDialect extends MySQL5Dialect{
   public CustomMySQLDialect()
   {
          super();
          registerFunction("median", new StandardSQLFunction("median"));
   }
}