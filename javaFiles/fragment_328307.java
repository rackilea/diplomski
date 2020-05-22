EventListener lst = new EventListener() {
    @Override
    public void fireEvent (Event e) {
        //do what you want with e
    }
}

someObject.setListener(lst);
someObject.somethingHappened();