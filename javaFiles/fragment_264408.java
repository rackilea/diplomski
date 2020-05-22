import java.util.ArrayList;

class A {
  private Long id; 
  private String name; 

  A(Long id){
      this.id = id;
  }

    @Override
  public boolean equals(Object v) {
        boolean retVal = false;

        if (v instanceof A){
            A ptr = (A) v;
            retVal = ptr.id.longValue() == this.id;
        }

     return retVal;
  }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
}

public class ArrayList_recap {
    public static void main(String[] args) {
        ArrayList<A> list = new ArrayList<A>(); 

        list.add(new A(0L));
        list.add(new A(1L));

        if (list.contains(new A(0L)))
        {
            System.out.println("Equal");
        }
        else
        {
            System.out.println("Nah.");
        }    
    }

}