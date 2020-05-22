public class SpecificRule 
    extends PrioritizedRule 
    implements Comaparable<SpecificRule> {

    private double specificValue;

    @Override
    public int compareTo(SpecificRule y) {
        int c = Integer.compare(this.getPriority(), y.getPriority());
        if (c == 0) {
            return Double.compare(this.getSpecificValue(), y.getSpecificValue());
        }
        return c;
    }

    //Getters & Setters

}