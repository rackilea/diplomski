public class Controller {

    private final Navigatable navigatable;
    private final Pageable pageable;

    public Controller(Navigatable navigatable, Pageable pageable) {
        this.navigatable = navigatable;
        this.pageable = pageable;

        navigatable.addActionListener(new ButtonListener());
    }

    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            pageable.showView("secondPage");
        }
    }
}