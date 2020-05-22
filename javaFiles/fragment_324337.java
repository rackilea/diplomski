public interface polymorphicObj{
     public method();
}
public class Filter<GENERIC implements polymorphicObj>{

     public filter(GENERIC obj){
           obj.method();   //you don't need to know of which specific type is polymorphicObj
     }
}