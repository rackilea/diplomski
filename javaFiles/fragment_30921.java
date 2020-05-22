public class Main {
    public static void main(String[] args) throws Exception {
        SubjectInterface subject = (SubjectInterface) Proxy.newProxyInstance(
                SubjectInterface.class.getClassLoader(),
                new Class[] { SubjectInterface.class }, new DynamicProxyHandler(new SubjectInterfaceImp()));
        System.out.println("in Main: subject.hello() = " + subject.hello());
    }
}