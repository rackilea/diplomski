public HelloStudentsServiceResponseType greetStudents(HelloStudentsServiceRequestType req) {

    WorkshopType ws;
    // unmarshall workshop data
    Element element = req.getWorkshop(); // workshop is retrieved as DOM 
    try {
        Unmarshaller u = jc.createUnmarshaller(); // jaxb ri unmarshaller not thread safe: https://jaxb.java.net/guide/Performance_and_thread_safety.html
        u.setSchema(workshopSchema); // enable validation by workshopType.xsd
        ws = u.unmarshal(element, WorkshopType.class).getValue(); // unmarshal
    } catch (JAXBException e) {
        // this is fatal
        throw new RuntimeException("fatal: invalid workshop data: ", e);
    }

    // unmarshall students
    List<String> studentGreetings = new ArrayList<>();
    for(Element studentElement : req.getStudentList().getStudent()) { // retrieve students as DOMs
        try {
            StudentType st;
            Unmarshaller u = jc.createUnmarshaller(); // jaxb ri unmarshaller not thread safe: https://jaxb.java.net/guide/Performance_and_thread_safety.html
            u.setSchema(studentSchema); // enable validation by studentType.xsd
            st = u.unmarshal(studentElement, StudentType.class).getValue();
            studentGreetings.add("Dear " + st.getName() + ", " + st.getBirth() + ", welcome in the workshop!");
        } catch (JAXBException e) {
            Throwable cause = e.getLinkedException();
            if(cause != null) {
                studentGreetings.add("Dear student, your data is invalid: " + cause.getMessage());
            }
            else {
                studentGreetings.add("Dear student, there's an unknown problem with your data");
            }
        }
    }

    // construct response
    HelloStudentsServiceResponseType response = new HelloStudentsServiceResponseType();
    response.setGreetingHeader("I'd like to greet everybody in the " + ws.getName() + " workshop. " +
            "Your tutor is " + ws.getTutor());
    response.getStudentGreeting().addAll(studentGreetings);

    return response;
}