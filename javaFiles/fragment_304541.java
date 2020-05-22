class CheckList {
    private String id = "123";
    private String Q1 = "This is Question 1";
    private String[] Q2 = {"Part 1", "Part 2"};
}


final String jsonObject = new Gson().toJson(new CheckList());

System.out.print(jsonObject);