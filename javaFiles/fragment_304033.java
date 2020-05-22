public class Class1 implements SomeInterface{

    String string;

    public Class1(String string) {
        this.string = string;
    }

    //some code

    @Override
    public void giveString(String string) {
        //do whatever with the string
        this.string=string;

    }

    @Override
    public String getString() {
        return string;
    }



}