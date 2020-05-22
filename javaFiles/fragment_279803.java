public void myFunction() throws CustomException {
    List<MyError> errors = new ArrayList<MyError>();
    while(stuff) {
        try {
            DoSomething() // throws an exception
        }
        catch (Exception ex) {
            errors.add(new MyError(some, stuff, of, mine, ex));
        }
    }
    if (errors.size() > 0) {
       throw new CustomException(errors);
    }
}