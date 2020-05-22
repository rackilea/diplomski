@GroupSequence({ First.class, Second.class })
public class MyBean {
   @NotEmpty(groups = First.class)
   @Digits(integer = 3, fraction = 0, groups = Second.class)
   private String code;
}