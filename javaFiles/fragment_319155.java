@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Category.class,
                new PropertyEditorSupport() {

                    @Override
                    public void setAsText(String text) {
                        // replace the dao with your appropriate repository call
                        Category category = dao.find(Category.class,
                                Integer.parseInt(text));
                        setValue(category);
                    }
                });
    }