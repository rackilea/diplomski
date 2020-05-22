class classView extends JFrame {

    private classModel model;

    public classView ( classModel model ) {
        this.model = model;

        this.setBounds( 400, 400, 300, 300 );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        addComponentsToPane();
        this.pack();
    }

    private void addComponentsToPane (  ) {
        Container pane = this.getContentPane();
        // This is where I add the buttons and other fun stuff
    }

}