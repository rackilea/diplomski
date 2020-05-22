public class Checker {

   private final List<Error> errors = new ArrayList<Error>();
   private final List<Check> checks = new ArrayList<Check>();

   public Checker() {
     checks.add(new DateIsParsableCheck().add(new DateIsInTheFurutreCheck());
     checks.add(new UrlIsWellFormed().add(new UrlIsAccessible());

     checks.add();
     ..
   }

   public void check(Data d) {
     for (Check c : checks) {
       Error e = c.run(d, errors);
       if (e != null) 
         errors.add(e);
     }
   }
}