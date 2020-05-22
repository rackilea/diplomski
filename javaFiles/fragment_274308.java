@Table(
    name="UNQ_CONSTRAINT_NAME", 
    uniqueConstraints=
        @UniqueConstraint(columnNames={"title", "user_id"})
 )
 public class Task{
     //...
 }