IModel<String> model=new LoadableDetachableModel<String>() {
    private static final long   serialVersionUID    = 1L;
    @Override
    protected String load() {
        // this class does not really exist
        return LinkRandomizer.getNewRandomUrl();
    }
};
add(new ExternalLink("link", model));