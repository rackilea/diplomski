shell = new Shell();
    shell.setSize(450, 300);
    shell.setText("SWT Application");

    Button btnRadioButton = new Button(shell, SWT.RADIO);
    btnRadioButton.setBounds(0, 10, 90, 16);
    btnRadioButton.setText("Radio Button");

    Button btnRadioButton_1 = new Button(shell, SWT.RADIO);
    btnRadioButton_1.setBounds(0, 30, 90, 16);
    btnRadioButton_1.setText("Radio Button");

    Button btnRadioButton_2 = new Button(shell, SWT.RADIO);
    btnRadioButton_2.setBounds(0, 50, 90, 16);
    btnRadioButton_2.setText("Radio Button");

    Composite composite = new Composite(shell, SWT.NULL);
    composite.setBounds(0, 70, 300, 200);
    composite.setLayout(new RowLayout());

    Button btnRadioButton_3 = new Button(composite, SWT.RADIO);
    btnRadioButton_3.setBounds(0, 0, 90, 16);
    btnRadioButton_3.setText("Radio Button");

    Button button = new Button(composite, SWT.RADIO);
    button.setText("Radio Button");
    button.setBounds(0, 20, 90, 16);

    Button button_1 = new Button(composite, SWT.RADIO);
    button_1.setText("Radio Button");
    button_1.setBounds(0, 40, 90, 16);