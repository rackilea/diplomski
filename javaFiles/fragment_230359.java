public class Values{
    //Global in respect to object
    private int value = 0;

    public void setValue(int value) {
        //The variable "value" passed in is local
        this.value = value;
    }
}