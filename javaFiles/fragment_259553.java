public class Point {
    /*
     @XStreamAlias("real")
     @XStreamAlias("real2") 
     public Real y = new Real("y", "21");
     @XStreamAsAttribute
     public String id = "position";
     */

    @XStreamImplicit
     public List xy = new ArrayList();


     public void add(Real entry) {
                xy.add(entry);
        }

}