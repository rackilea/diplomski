public LifePathUI2() throws HeadlessException {
  cons = new GridBagConstraints();
  windowLayout = new BorderLayout();
  layout = new GridBagLayout();
  mainWindow = new JFrame();
  mainPanel = new JPanel();
  mainWindow.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
  init();
}