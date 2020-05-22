abstract class MyAbstractClass<T extends MyAbstractParameter> extends Thread {
    private List<T> list;
    public MyAbstractClass(List<T> list) { this.list = list; }
    public List<T> getList() { return list; }

    public void run() {
        for (T e : list) {
             doStuffWithList(e); 
        }
    }
    public abstract void doStuff(T element);
}