TitleAreaDialog tad = new TitleAreaDialog(getShell()) {

        @Override
        protected Control createContents(Composite parent) {
            Control control = super.createContents(parent);
            Label label = getTitleImageLabel();
            FormData data = (FormData) label.getLayoutData();
            data.left = new FormAttachment(0, 0);
            data.right = null;
            return control;
        }

    };
    tad.setTitle("title");
    tad.setTitleImage(Activator.imageDescriptorFromPlugin(
            Activator.PLUGIN_ID, "image.gif").createImage());
    tad.open();