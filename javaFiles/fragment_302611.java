Button button_2 = new Button(composite_1, SWT.FLAT);
    button_2.addSelectionListener(new SelectionAdapter() {
        @Override
        public void widgetSelected(SelectionEvent e) {

            FileOpener v = new FileOpener();
            File file = v.choosed();
            shell.forceActive();
            if(file != null) {
                Image image = new Image(shell.getDisplay(), file.getPath());
                Image image2 = main.ScaleImage(image, Image_input);
                Image_input.setImage(image2);
            }


        }
    });