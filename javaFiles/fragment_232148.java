public class View extends JPanel implements ActionListener {

  JButton transform = new JButton("Transform1");
  Model m;
  public View(Model m) {
       super();
       this.m = m;
       transform.setActionListener(this);
       // lay out the GUI
       setLayout(...);
       add(// whatever view you need to visualize the data);
       add(transform);
  }

  /**
   Make sure all of the GUI elements are correct */
  public void update() {
    State transformState = m.getTransformState();
    transform.setText(transformState.getNextStateDescription());

    // Draw the state of the file they loaded in, probably to another JPanel
  }

  public void actionPerformed(ActionEvent e) {
    m.transform();
  }

}