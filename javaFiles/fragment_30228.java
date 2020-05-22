@GET
@Path("/so-test")
@Produces({AgiMediaType.APPLICATION_XML, AgiMediaType.APPLICATION_JSON})
public RootClass getGreetings() {
    List<TestClassForSo> greetingList = new ArrayList<>();

    for (int i = 0; i < 3; i++) {
        TestClassForSo testClassForSo = new TestClassForSo();

        String id = "hello-word";
        List<String> greetings = new ArrayList<>(Arrays.asList("Hello World " + i));
        testClassForSo.id = id;
        testClassForSo.description = greetings;

        greetingList.add(testClassForSo);
    }

    RootClass r = new RootClass();
    r.greetingList = greetingList;
    return r;
}