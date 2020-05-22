public class StatusBar extends JPanel{ //Instead of JToolBar
    private JProgressBar progressBar = new JProgressBar(JProgressBar.HORIZONTAL);
    private JPanel progressPanel = new JPanel();
    private JPanel globalPanel = new JPanel();
    private JPanel cameraPanel = new JPanel();
    private JLabel cameraLabel = new JLabel("Camera: ");
    private JLabel cameraCoords = new JLabel();
    private JLabel globalLabel = new JLabel("Global: ");
    private JLabel globalCoords = new JLabel();

    public StatusBar(){
        progressPanel.setLayout(new BoxLayout(progressPanel, BoxLayout.X_AXIS));
        globalPanel.setLayout(new BoxLayout(globalPanel, BoxLayout.X_AXIS));
        cameraPanel.setLayout(new BoxLayout(cameraPanel, BoxLayout.X_AXIS));

        progressBar.setFocusable(false);
        progressBar.setPreferredSize(new Dimension(100,0));
        progressBar.setMaximumSize(new Dimension(150,20));
        progressBar.setStringPainted(true);

        progressPanel.add(tileLoadingLabel);
        progressPanel.add(Box.createHorizontalStrut(5));
        progressPanel.add(progressBar);
        globalPanel.add(globalLabel);
        globalPanel.add(globalCoords);
        globalPanel.add(separator);
        globalCoords.setPreferredSize(new Dimension(150,0));

        //Here is where I made the change(after extending JPanel and not JToolBar
        //I used the BorderLayout instead of the BoxLayout  
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(5,5,5,5));
        this.setPreferredSize(new Dimension(0,30));
        this.add(globalPanel,BorderLayout.WEST);
        this.add(Box.createHorizontalGlue());
        this.add(progressPanel,BorderLayout.EAST);
    }
}