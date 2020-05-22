...

    _39() {
        i = 100;
        foo();     <--------------- this calls this
    }                                            |
                                                 |
...                                              |
                                                 |
public class Rosea extends _39 {                 |
    ...                                          |
    public void foo() {                  <-------'
        System.out.println("Rose" + i);
    }
    ...
}