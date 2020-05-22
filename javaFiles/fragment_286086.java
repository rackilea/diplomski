public class MyClass {

private String arg1;
private Date arg2;
private Integer arg3;

public MyClass(String arg1, Date arg2, Integer arg3) {
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.arg3 = arg3;
    }

@Override
public String toString() {
        return "MyClass [arg1=" + arg1 + ", arg2=" + arg2 + ", arg3=" + arg3 + "]";
    }

}