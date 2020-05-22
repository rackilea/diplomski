IModel<MyObject> model = ...;
Link<MyObject> link = new Link<MyObject>("link", model) {
    public void onClick() {
        MyObject obj = getModelObject();
        setResponsePage(new MyPage(obj));
    }
};
add(link);