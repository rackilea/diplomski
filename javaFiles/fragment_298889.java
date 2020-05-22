public class Main {
    public static void main(String[] args) throws Exception {
        Client client = Client.create();

        Emp emp = new Emp();
        emp.name = "pee";

        Student stu = new Student();
        stu.name = "skillet";

        FormDataMultiPart multipart = new FormDataMultiPart()
                .field("emp", emp, MediaType.APPLICATION_JSON_TYPE)
                .field("student", stu, MediaType.APPLICATION_JSON_TYPE);

        final String url = "http://localhost:8080/api/multipart";
        String response = client.resource(url).type(MediaType.MULTIPART_FORM_DATA_TYPE)
                .post(String.class, multipart);
        System.out.println(response);   
    }
}