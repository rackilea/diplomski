public class Derived extends Super
{
    private Derived(DTO1 dto1Object){ super(dto1Object); }
    private Derived(DTO2 dto2Object){ super(dto2Object); }

    public static Derived create(Object obj) {
       //some_condition to check if passed object obj is dto1Object                 
       //do something with dto1Object
       if (someCondition) {
         return new Derived((DTO1) obj);
       }

       //some_condition to check if passed object is dto2Object                               
       //do something with dto2Object
       if (someOtherCondition) {
         return new Derived((DTO2) obj);
       }

       // ...?
    }
}