Result result = fetchSomething(String parameter);
if (result.hasErrors()) {
    List<String> errors = result.getErrors();
} else {
    String fetched = result.getValue();
}