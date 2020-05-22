public class MySuperStoreAlotOfValuesCheckbox extends JCheckBox{
    private static final long serialVersionUID = 1L;
    private int theInt;
    ... all the values in the world...
    public MySuperStoreAlotOfValuesCheckbox(String text){
        super(text);
    }
    public MySuperStoreAlotOfValuesCheckbox(String text, int theInt){
        super(text);
        this.theInt = theInt;
    }
}