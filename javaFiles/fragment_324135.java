public class MainApp {
    public static void main(String[] args) {
        IUser userProxy = (IUser) DebugProxy.newInstance(new User("foo"));
        System.out.println(userProxy.getName());
    }
}