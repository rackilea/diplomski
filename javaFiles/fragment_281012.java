public interface Audited {
    void setDateAdded(Date date);
    //etc, etc
}

public class Apple implements Audited { /*...*/ }

public class Banana implements Audited { /*...*/ }