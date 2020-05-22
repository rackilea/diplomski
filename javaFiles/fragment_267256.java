@Entity
@Table(name = "users")
@Data
public class User {
   @Id
   private int id;  
   private String name;
}
@Entity
@Table(name = "books")
@Data
public class Book {
   @Id
   private int id;
   private String title;
}
@Entity
@Table(name = "years")
@Data
public class Year {
   @Id
   private int id;
   private int year;
}