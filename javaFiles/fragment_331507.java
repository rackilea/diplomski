public interface Step {
    void doIt(String msg, Runnable r);
    default Step then(String msg, Runnable r) {
        doIt(msg, r);
        return this;
    }
}
public static Step execute(String msg, Runnable r) {
    Step s=(m,x)-> {
        x.run();
        System.out.println(msg);
    };
    return s.then(msg, r);
}