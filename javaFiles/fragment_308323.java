public final class MainWindow{
    private final JFrame main_f;

    public MainWindow(){
        main_f = new JFrame("xx");
        main_f.getContentPane().setLayout(new BorderLayout());
        main_f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        .
        .
        .
    }

    public final JFrame getMainFrame(){
        return main_f;
    }
    .
    .
    .
}