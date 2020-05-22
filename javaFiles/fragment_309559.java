public enum AgeRange {
    A18TO23 ("18-23"),
    A24TO29 ("24-29"),
    A30TO35("30-35");

    private String value;

    AgeRange(String value){
        this.value = value;
    }

    public String toString(){
        return value;
    }

    public static AgeRange getByValue(String value){
        for (final AgeRange element : EnumSet.allOf(AgeRange.class)) {
            if (element.toString().equals(value)) {
                return element;
            }
        }
        return null;
    }
}