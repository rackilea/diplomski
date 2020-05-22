patchUsersExceptCurrentUser("Example", new ParseListener() {
    @Override
    public void onSucess((List<Object>objects) {
        myArray = objects;
    }

    @Override
    public void onError(ParseException e) {
        //show error
    }
});