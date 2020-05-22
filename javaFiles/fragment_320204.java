@Entity
public class Game {
...
     // rewrite your logic here in HQL
     @Formula("case when startTime >= endTime then 'FINISHED' ... end")
     private String status;