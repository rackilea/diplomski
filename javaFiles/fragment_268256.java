myList.forEach(new Consumer<Object>() {
    @Override
    public void accept (Object s) {
        System.out.println(s);
    }
});