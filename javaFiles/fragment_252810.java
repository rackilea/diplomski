Button[] radioButton = new Button[answers.size()];
        for (int i = 0; i < answers.size(); i++) {
            String ans = answers.get(i).getValue();
            radioButton[i] = new Button(container, SWT.RADIO);
            radioButton[i].setText(ans);
        }

        Text[] textField = new Text[answers.size()];
        for (int i = 0; i < answers.size(); i++) {
            textField[i] = new Text(container, SWT.SINGLE | SWT.BORDER);

            radioButton[i].addSelectionListener(new SelectionAdapter(){
                @Override
                public void widgetSelected(SelectionEvent arg0) {
                  textField[i].setEnabled(radioButton[i].getSelection());
                }});

            textField[i].addModifyListener(new ModifyListener(){
                @Override
                public void modifyText(ModifyEvent arg0) {
                  // your stuff
                }});
        }