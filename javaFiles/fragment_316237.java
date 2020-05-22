@Test
@DatabaseSetup("dataset.xml")
public void test() throws UnsupportedEncodingException {
    ClientResponse response = resource()
        .path("students").path("getStudent").path("100500")
        .accept(MediaType.APPLICATION_XML)
        .get(ClientResponse.class);

    Student student = (Student) response.getEntity(Student.class);
    System.out.println(student);
}