public abstract class Person {
    private String breakfast;
    private String lunch;
    // ... other fields

    public abstract void getMeals();

    public String getBreakfast() { return breakfast; }
    // ... other getters
}

public class Father extends Person {
     @Override
     public void getMeals() {
         // implement Father-specific code here
     }
}

public class Mother extends Person {

     @Override
     public String getMeals() {
        StrngBuilder sb = new StringBuilder() ;

        sb.append(getBreakfast());
        sb.append(getLunch());
        sb.append(getDinner());

        return sb.toString();
    }
}