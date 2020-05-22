@Path("multipart")
public class MultipartResource {

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response doPost(@FormDataParam("emp") Emp emp,
                           @FormDataParam("student") Student student) {
        StringBuilder builder = new StringBuilder();
        builder.append("Emp:").append(emp.name).append("\n");
        builder.append("Student:").append(student.name).append("\n");
        return Response.ok(builder.toString()).build();
    }

    public static class Student {
        public String name;
    }

    public static class Emp {
        public String name;
    }
}