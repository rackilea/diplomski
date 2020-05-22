public interface Condition<Type T> {
    public boolean process(T object); 
} 

ArrayList row = new ArrayList<Condition>(10); 
row.add( new Condition<YourObject>() { 
                public boolean process(YourObject obj) { 
                       if ( obj.property > 0 ) return true; 
                       else return false; 
                }); 
row.add( new Condition<YourObject>() { 
                public boolean process(YourObject obj) { 
                       if ( obj.property2 == 100 ) return true; 
                       else return false; 
                });