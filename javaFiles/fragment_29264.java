public static class Command {
  protected String code;
  protected String desc;
  public String getCode() {return code;}
  public String getDesc() {return desc;}
  public Command (String code, String desc) {
    this.code = code;
    this.desc = desc;
  }
  public String toString() {return code;}
}

public class StandardCommands {
  public static Command READ = new Command("READ", "read a record");
  public static Command CREATE = new Command("WRITE", "create a record");
  public static Command EDIT = new Command("WRITE", "modify a record");
}
public class FurtherCommands extends StandardCommands {
  public static Command LIST = new Command("LIST", "list all records");
}

public class QueryCommands extends FurtherCommands {
  public static class QueryCmd extends Command {
    protected String search;
    public String getSearch() {return search;}
    // constructor..
  }
  public static QueryCmd QUERY_EXAMPLE = new QueryCmd("QUERY", "example", "query for specified string");


  public static QueryCmd createQuery (String search) {
    return new QueryCmd( "QUERY", search, "query for specified string");
  }
}