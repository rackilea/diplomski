public void createPartControl(Composite parent) {

    ScrolledForm scrolledForm = formToolkit
            .createScrolledForm(parent);
    formToolkit.paintBordersFor(scrolledForm);
    scrolledForm.setText("New ScrolledForm");
    formToolkit.decorateFormHeading(scrolledForm.getForm());

    scrolledForm.getForm().getHead().addMouseListener(new MouseListener() {

        @Override
        public void mouseDoubleClick(MouseEvent e) {
            System.out.println("mouseDoubleClick");
        }

        @Override
        public void mouseDown(MouseEvent e) {
            System.out.println("mouseDown");
        }

        @Override
        public void mouseUp(MouseEvent e) {
            System.out.println("mouseUp");
        }

    });

}