public class ArrivalDetails {

    String origin;
    String airline1;

    public ArrivalDetails(String[] singleRowArray) {
        this.origin = singleRowArray[0];
        this.airline1 = singleRowArray[1];
    }
}