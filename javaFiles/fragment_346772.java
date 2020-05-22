public class Starter {
public static void main(String[] args) {
    MyBlueTooth bt = new MyBlueTooth();
    MyWifi wf = new MyWifi();
    MyConnectionManager<MyBlueTooth> test = new MyConnectionManager<MyBlueTooth>(bt);
    MyConnectionManager<MyWifi> test2 = new MyConnectionManager<MyWifi>(wf);

}