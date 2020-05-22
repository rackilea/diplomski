public enum MySingleton{
    private MySingleton(){}
    private static class Holder {
         static final MySingleton instance = new MySingleton();
    }
    static MySingleton getInstance() { return Holder.instance; }
}