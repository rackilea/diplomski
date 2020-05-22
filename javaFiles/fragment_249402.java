public class Main {

public static final String CONST;

static {
    if((System.currentTimeMillis() % 2) == 0) {
        CONST = "FOO";
    }
    else {
        CONST = "BAR";
    }
}

public final String CONST2;

public Main(){
    if((System.currentTimeMillis() % 2) == 0) {
        CONST2 = "FOO";
    }
    else {
        CONST2 = "BAR";
    }   
}