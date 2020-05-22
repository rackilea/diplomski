public class AxisClient
{
    public static void main(String[] args) throws Exception
    {
    String endPoint = "http://localhost:8080/StudentServiceImplService/StudentServiceImpl";
    Service service2 = new Service();
    Call call2 = (Call) service2.createCall();
    call2.setTargetEndpointAddress(new java.net.URL(endPoint));
    call2.setOperationName(new QName("http://services.tuto.java.com/","getStudents"));
    call2.setReturnType(new QName("","student"), Student.class);
    call2.setReturnType(new QName("", "student"));
    call2.registerTypeMapping(Student.class, new QName("", "student"), null,new BeanDeserializerFactory(Student.class, new QName("", "student")));
    List<Student> students = (List<Student>) call2.invoke(new Object[0]);
    for (Student student : students)
    {
        System.out.println(student);
    }
    }
 }