import org.hibernate.annotations.SQLDelete;

@SQLDelete(sql = "delete from whatever where id = ?")
public class Main {
  public static void main(String[] args) {
    SQLDelete annotation = Main.class.getAnnotation(SQLDelete.class);
    System.out.println("Sql delete = " + annotation);
    System.out.println("Sql = " + annotation.sql());
    try {
      Class.forName("org.hibernate.Session");
    } catch (ClassNotFoundException e) {
      System.out.println("org.hibernate.Session is not present");
    }
  }
}