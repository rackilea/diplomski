ed.setEditorKit(new HTMLEditorKit() {

            @Override
            public ViewFactory getViewFactory() {
                return new HTMLFactory() {

                    @Override
                    public View create(Element elem) {
                        View view = super.create(elem);
                        if (view instanceof ImageView) {
                            ((ImageView) view).setLoadsSynchronously(true);
                        }
                        return view;
                    }
                };
            }
        });