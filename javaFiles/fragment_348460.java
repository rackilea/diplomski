public abstract class MyData {
    public abstract void setsName(String name);
    public abstract String getsName();
    public abstract void setsSummary(String summary);
    public abstract String getsSummary();
}
public class DataTypeOne extends MyData {
    public String getsName() {
        // implement
    }
    public void setsName(String name) {
        // implement
    }

    // Still have to implement these!!!
    public String getsSummary() {
        // raise an exception or something if appropriate
    }
    public void setsSummary(String summary) {
        // raise an exception or something if appropriate
    }
}
// Same for DataTypeTwo