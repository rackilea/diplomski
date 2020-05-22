public class Components {

    private int numberOfNets; 
    private String nameOfComp;
    private String nameOfCompPart;
    private int numOfPin;

    public components(int i, String compName, String partName, int pin) {
        setNumberOfNets(i);
        setNameOfComp(compName);
        setNameOfCompPart(partName); 
        setNumOfPin(pin);
    }

    public void setNumberOfNets(int numberOfNets) {
        this.numberOfNets = numberOfNets;
    }

    // Similarly other getter and setters
}