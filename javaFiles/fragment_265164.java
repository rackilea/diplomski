//---> input        
        myPackage = new Text(grpConnection, SWT.BORDER);
        myPackage.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        //---> input event
        myPackage.addModifyListener(new ModifyListener(){
            // decorator for UI warning
            ControlDecoration decorator;

            /*
             * In this anonymous constructor we will initialize what needs to be initialized only once, namely the decorator.
             */
            {
                decorator = new ControlDecoration(myPackage, SWT.CENTER);
                decorator.setDescriptionText("Not a valid package");
                Image image = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR).getImage();
                decorator.setImage(image);
            }

            @Override
            public void modifyText(ModifyEvent e) {
                if (true) { // place your condition here
                    decorator.show();
                }
                else {
                    decorator.hide();
                }
            }
        });