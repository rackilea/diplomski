import javax.swing.*;


public class menuBar extends JMenuBar{

  public menuBar(){

    JMenu file = new JMenu("File");
    this.add(file);
    JMenuItem open = new JMenuItem("Open");
    file.add(open);
    JMenuItem neww = new JMenuItem("New");
    file.add(neww);

    JMenu edit = new JMenu("Edit");
    this.add(edit);
    JMenuItem color = new JMenuItem("Change Color");
    edit.add(color);

    JMenu help = new JMenu("Help");
    this.add(help);
    JMenuItem about = new JMenuItem("About");
    help.add(about);
  }
}