Label lblNewLabel_1 = new Label(composite, SWT.BORDER);
        GridData gd_lblNewLabel_1 = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
        gd_lblNewLabel_1.widthHint = 193;
        gd_lblNewLabel_1.heightHint = 193;
        lblNewLabel_1.setLayoutData(gd_lblNewLabel_1);
        Image image = new Image(display, "where the image is");
        lblNewLabel_1.setImage(image);
        lblNewLabel_1 = new Label(composite, SWT.BORDER);
        lblNewLabel_1.setText("image label");