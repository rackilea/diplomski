public class SingleSleeper {
   @ManyToOne(optional = false, fetch = FetchType.LAZY)
   private ParentEntity parent;

   ...
}

public class RutEntry {
   @ManyToOne(optional = false, fetch = FetchType.LAZY)
   private ParentEntity parent;

}