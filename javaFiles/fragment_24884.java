FileUpload fileUpload=new FileUpload();
        fileUpload.addChangeHandler(new ChangeHandler() {
            public void onChange(ChangeEvent event) {
                if(isValidType()){ 
                     form.submit();
                 }
            }
        });