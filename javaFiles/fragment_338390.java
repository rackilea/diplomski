public interface NewInterface {
    public void setI(Integer i);
    public Integer add() ;
}

public class NewClass implements NewInterface{

    private Integer i;

    public NewClass() {
        System.out.println("NewClass()");
    }

    public void setI(Integer i) {
        System.out.println("setI(): " + i);
        this.i = i;
    }

    public Integer add() {
        return i + 1;
    }
}