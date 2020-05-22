import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelGUI extends JPanel {
  private static final long serialVersionUID = 1L;
  public int visiblePoints;
  public int newStartingPoint;
  ToolBar myToolBar;
  int frameWidth = 600;
  int frameHeight = 300;

public PanelGUI(double[] myDBL, String[] mySTR){
    newStartingPoint = 0;
    visiblePoints = 5000;
    addComponentsToPane(this, myDBL,mySTR);
}

public void addComponentsToPane(Container pane, final double[] myDBL, final String[] mySTR) {
    pane.removeAll();
    myToolBar=new ToolBar(myDBL,mySTR);
    pane.add(myToolBar);
    myToolBar.hRescaleButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae) {

            String str = JOptionPane.showInputDialog(null, "Number of milliseconds shown in window : ", "Horizontal Rescale", 1);
            if(str != null) {
                int numPoints = Integer.parseInt(str);
                JOptionPane.showMessageDialog(null, "You entered: "+numPoints+"ms = "+(numPoints/1000)+"sec.", "Horizontal Rescale", 1);
                this.removeAll();
                visiblePoints = numPoints;
                frameWidth = this.getWidth();
                frameHeight = this.getHeight();
                setSize(frameWidth,frameHeight);
                addComponentsToPane(this,myDBL,mySTR);//THIS IS WHERE THE ERROR IS
                setSize(frameWidth,frameHeight);
              }
              else{
                  JOptionPane.showMessageDialog(null, "You pressed cancel button.","Horizontal Rescale", 1);
              }
      }});
      System.out.println("pane reloaded successfully");
}
}