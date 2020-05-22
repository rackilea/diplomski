ObjectMapper mapper = new ObjectMapper();
    String jsonString="{\"call\":\"SimpleAnswer\",\"environment\":\"prod\",\"question\":{\"assertions\":[{\"assertionType\":\"regex\",\"expectedString\":\"(.*)world cup(.*)\"}],\"questionVariations\":[{\"questionList\":[\"when is the next world cup\"]}]}}";
    TestClass sc=mapper.readValue(jsonString,TestClass.class);

    // to update environment
    sc.setEnvironment("new Environment");
    System.out.println(sc);

    //to update assertionType
    Question que=sc.getQuestion();
    List assertions=que.getAssertions();
    for (int i = 0; i < assertions.size(); i++) {
        Assertion ass= (Assertion) assertions.get(i);
        ass.setAssertionType("New Type");
    }