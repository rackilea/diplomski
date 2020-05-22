public class Toidubaas {

    public  SimpleIntegerProperty rbCal = new SimpleIntegerProperty();
    public  SimpleIntegerProperty rbProt = new SimpleIntegerProperty();
    public  SimpleIntegerProperty rbCarb = new SimpleIntegerProperty();
    public  SimpleIntegerProperty rbFat = new SimpleIntegerProperty();
    public  SimpleStringProperty rbMeal = new SimpleStringProperty();

    //Empty Constructor (only need this if standardized to first approach)
    public Toidubaas() {}

    //Parameterized Constructor (only need this if standardized to second approach) 
    public Toidubaas(String sbMeal, Integer sbCal, Integer sbProt, Integer sbCarb, Integer sbFat) {

        rbMeal.set(sbMeal);
        rbCal.set(sbCal);
        rbProt.set(sbProt);
        rbCarb.set(sbCarb);
        rbFat.set(sbFat);    
    }

    //Getters/Setters
    ...
}