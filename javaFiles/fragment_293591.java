add(new Link<Void>("goSk") {

    private static final long serialVersionUID = 1L;

    @Override
    public void onClick() {
        getSession().setLocale(new Locale("sk", "SK"));
    }
});

add(new Link<Void>("goEn") {

    private static final long serialVersionUID = 1L;

    @Override
    public void onClick() {
        getSession().setLocale(Locale.US);
    }
});