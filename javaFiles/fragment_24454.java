JFrame mainframe = new JFrame();
JPanel mainPanel = new JPanel();
GridBagLayout gridLayout = new GridBagLayout();
mainPanel.setLayout(gridLayout);

//GridBagConstraints allow you to set various features of the way the components appear
//in the grid. You can set this up as you wish, but defaults are fine for this example
GridBagConstraints gridConstraints = new GridBagConstraints();

//Just using FlowLayout as a test for now
JPanel centerPanel = new JPanel(new FlowLayout());
centerPanel.add(new JLabel("Hello"));
centerPanel.add(new JLabel("Centered"));

mainPanel.add(centerPanel, gridConstraints);

mainFrame.add(mainPanel);