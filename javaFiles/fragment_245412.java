final Text text = new Text(parent, SWT.MULTI | SWT.BORDER | SWT.WRAP);
    text.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

    Point textSize = text.computeSize(SWT.DEFAULT, SWT.DEFAULT);
    Rectangle textTrim = text.computeTrim(0, 0, textSize.x,
            text.getLineHeight());
    final int textPadding = textTrim.height - text.getLineHeight();

    text.addModifyListener(new ModifyListener() {

        @Override
        public void modifyText(ModifyEvent e) {
            int height = text.getLineCount() * text.getLineHeight()
                    + textPadding;
            text.setSize(text.getSize().x, height);
            // need to layout parent, in order to change position of
            // siblings
            parent.layout();
        }
    });