public class Foo {
   private List<FooEnum> enumValues;

   @Override
   public int hashCode() {
       final int prime = 31;
       int result = 1;
       result = prime * result
               + ((enumValues == null) ? 0 : enumValues.hashCode());
       return result;
   }

   @Override
   public boolean equals(Object obj) {
       if (this == obj)
           return true;
       if (obj == null)
           return false;
       if (getClass() != obj.getClass())
           return false;
       Foo other = (Foo) obj;
       if (enumValues == null) {
           if (other.enumValues != null)
               return false;
       }
       else if (!enumValues.equals(other.enumValues))
           return false;
       return true;
   }


}