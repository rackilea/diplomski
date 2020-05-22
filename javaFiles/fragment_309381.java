// actually Test3 would be a better name, but I'll leave that to you
public class Test {   
     public static void main(String[] args) {
         Customer c = new Customer();
         c.setName("K1");

         Customer c2 = c;
         c.setNbrOf(4+1);
         c2.setNbrOf(c.getNbrOf()+1);
         int tal = c.getNbrOf()+5;
         int tal2 = ++tal;
         System.out.println("Namn: "+c.getName()+" ålder: "+c2.getNbrOf()+" reference to c:"+ c);
         andra(c, tal2);
         System.out.println("Namn: "+c.getName()+" ålder: "+c.getNbrOf()+", 
         Tal: "+tal);
    }
    public static void andra(Customer p, int tal3) {
         p.setName("K2");
         tal3=9;
         System.out.println("BEFORE - reference to p: "+p+" tal: "+tal3+" p.nbrOf:"+p.getNbrOf());
         p.setNbrOf(tal3);
         System.out.println("AFTER - reference to p: "+p+" tal: "+tal3+" p.nbrOf:"+p.getNbrOf());

    }
}