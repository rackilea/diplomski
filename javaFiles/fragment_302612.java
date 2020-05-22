Button button_2 = new Button(composite_1, SWT.FLAT);
    button_2.addSelectionListener(new SelectionAdapter() {
        @Override
        public void widgetSelected(SelectionEvent e) {

            FileDialog test = new FileDialog(shell);
            test.open();

            File file = new File(test.getFilterPath()+"\\"+test.getFileName());
            if(file != null) {
                Image image = new Image(shell.getDisplay(), file.getPath());
                Image image2 = main.ScaleImage(image, Image_input);
                Image_input.setImage(image2);
            }


        }
    });