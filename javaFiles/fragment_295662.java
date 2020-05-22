// instantiated in the constructor
    private final MyValidator myValidator

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(this.myValidator);
    }