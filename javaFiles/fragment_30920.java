public class SubjectInterfaceImp implements SubjectInterface {
    @Override
    public String hello() {
        System.out.println("in SubjectInterfaceImp: Greeting!");
        return "hello";
    }
}