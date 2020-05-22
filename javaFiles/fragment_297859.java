public class NumericKB extends javax.swing.JPanel implements ActionListener {
  ...

  private void init() {
    ...
    JButton aButton = new JButton();
    aButton.addActionListener(this);

    JPanel aPanel= new JPanel();
    aPanel.add(aButton);
    ...
  }

  ...

  @Override
  public void actionPerformed(ActionEvent e) {   
    Component source = (Component) e.getSource();

    // recursively find the root Component in my main app class
    while (source.getParent() != null) {            
        source = source.getParent();
    }

    // once found, call the dispatch the current event to the root component
    if (source instanceof ActionListener) {
      ((ActionListener) source).actionPerformed(e);
    }
  }

...
}