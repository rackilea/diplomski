public class MyService {
    public static void main(String[] args) {
        MyService myService = new MyService();

        myService.method("name", "hello");
        myService.method("name", new Student());
        myService.<List<Student>>method("name", Lists.newArrayList(new Student()));
    }

    public <T> void method(String name, T para) {
        System.out.println(para);
    }
}