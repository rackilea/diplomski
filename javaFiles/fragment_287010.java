Matcher<Item> matcher = new BaseMatcher<Item>() {

    @Override
    public boolean matches(Object item) {
        Item myItem = (Item) item;
        return check(myItem.property1, myItem.property2);
    }

    @Override
    public void describeTo(Description description) {
        // describe it
    }

}