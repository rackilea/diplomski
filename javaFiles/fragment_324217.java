public enum States {
    SEL("Selangor"),
    WP("Wilayah Persekutuan"),      
    KEL("Kelantan"),
    LAB("Labuan"),
    PER("Perlis");  

    private String value;       
    States(String val){
        this.value = val ;
    }       
    public String getValue(){
        return value;
    }

    public static States[] getSortedValue(){
        States[] values = States.values();
        Arrays.sort(values,(s1,s2)->s1.getValue().compareTo(s2.getValue()));
        return values;
    }
}