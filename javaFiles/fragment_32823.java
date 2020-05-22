@Table(name = "myTable", indexes = { @Index("name")})
@Entity
class MyEntity {
      @Index(name = "name")
      private String name;

      @Index(name = "age")
      private int age;
}