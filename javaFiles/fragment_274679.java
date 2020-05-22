@IdClass(value = DivisionPK.class)
public class Division {

   @EmbeddedId
   private Season season;

   @Id
   private String level;

   @Id
   private String group;
}

@Embeddable
public class Season implements Serializable {
  // you fields and code here
}