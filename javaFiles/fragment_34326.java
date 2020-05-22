ScrolledComposite scroll = new ScrolledComposite(shell, SWT.V_SCROLL|SWT.H_SCROLL);
scroll.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));

Group grpDraw = new Group(scroll, SWT.V_SCROLL|SWT.H_SCROLL);
grpDraw.setText("Picture");
grpDraw.setBounds(0, 0, 200, 200);

Button btnPaint = new Button(shell, SWT.NONE);
btnPaint.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
btnPaint.addSelectionListener(new SelectionAdapter() {
        @Override
        public void widgetSelected(SelectionEvent e) {
            Image image = new Image(display, 1000, 1000);
            GC gc = new GC(image);
            gc.setBackground(display.getSystemColor(SWT.COLOR_YELLOW));
            gc.fillOval(50,50,100,100);
            gc.setForeground(display.getSystemColor(SWT.COLOR_DARK_GREEN));
            gc.dispose();
            grpDraw.setBackgroundImage(image);
            scroll.setContent(grpDraw);
        }
    });
btnPaint.setText("paint");