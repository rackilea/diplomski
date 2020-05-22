package pkg;

import static pkg.MyClass.State.*;

public class MyClass {
    enum State {
        STATE1, STATE2, STATE3
    }

    State curState;

    // ...
    public MyClass() {
        curState = STATE1;
    }
}