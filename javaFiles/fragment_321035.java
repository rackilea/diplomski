import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.*;
import javax.swing.plaf.metal.*;

public class ComboBoxUIDemo {
  private static Color BORDER = Color.GRAY;
  public JComponent makeUI() {
    //UIManager.put("ComboBox.foreground", Color.WHITE);
    //UIManager.put("ComboBox.background", Color.BLACK);
    //UIManager.put("ComboBox.selectionForeground", Color.CYAN);
    //UIManager.put("ComboBox.selectionBackground", Color.BLACK);

    //UIManager.put("ComboBox.buttonDarkShadow", Color.WHITE);
    //UIManager.put("ComboBox.buttonBackground", Color.GRAY);
    //UIManager.put("ComboBox.buttonHighlight", Color.WHITE);
    //UIManager.put("ComboBox.buttonShadow", Color.WHITE);
    //UIManager.put("ComboBox.editorBorder", BorderFactory.createLineBorder(Color.RED));

    Box box = Box.createVerticalBox();

    UIManager.put("ComboBox.border", BorderFactory.createEmptyBorder());
    for(int i=0; i<2; i++) { // Defalut
      JComboBox<String> cb = new JComboBox<>(makeModel());
      if(i%2==0) setEditable(cb);
      setPopupBorder(cb);
      box.add(cb);
      box.add(Box.createVerticalStrut(10));
    }

    {
      // Override MetalComboBoxUI#paintCurrentValueBackground(...)
      JComboBox<String> cb = new JComboBox<>(makeModel());
      cb.setUI(new MetalComboBoxUI() {
        @Override public void paintCurrentValueBackground(
        Graphics g, Rectangle bounds, boolean hasFocus) {
          //if (MetalLookAndFeel.usingOcean()) {
          if(MetalLookAndFeel.getCurrentTheme() instanceof OceanTheme) {
            g.setColor(MetalLookAndFeel.getControlDarkShadow());
            g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height - 1);
            //COMMENTOUT>>>
            //g.setColor(MetalLookAndFeel.getControlShadow());
            //g.drawRect(bounds.x + 1, bounds.y + 1, bounds.width - 2,
            //           bounds.height - 3);
            //<<<COMMENTOUT
            if (hasFocus && !isPopupVisible(comboBox) && arrowButton != null) {
              g.setColor(listBox.getSelectionBackground());
              Insets buttonInsets = arrowButton.getInsets();
              if (buttonInsets.top > 2) {
                g.fillRect(bounds.x + 2, bounds.y + 2, bounds.width - 3,
                           buttonInsets.top - 2);
              }
              if (buttonInsets.bottom > 2) {
                g.fillRect(bounds.x + 2, bounds.y + bounds.height -
                           buttonInsets.bottom, bounds.width - 3,
                           buttonInsets.bottom - 2);
              }
            }
          } else if (g == null || bounds == null) {
            throw new NullPointerException(
              "Must supply a non-null Graphics and Rectangle");
          }
        }
      });
      setPopupBorder(cb);

      box.add(cb);
      box.add(Box.createVerticalStrut(10));
    }

    UIManager.put("ComboBox.border", BorderFactory.createLineBorder(BORDER));
    for(int i=0; i<2; i++) { // BasicComboBoxUI
      JComboBox<String> cb = new JComboBox<>(makeModel());
      if(i%2==0) setEditable(cb);
      cb.setUI(new BasicComboBoxUI());
      setPopupBorder(cb);
      box.add(cb);
      box.add(Box.createVerticalStrut(10));
    }

    JPanel p = new JPanel(new BorderLayout());
    p.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
    p.add(box, BorderLayout.NORTH);
    return p;
  }
  private static void setEditable(JComboBox cb) {
    cb.setEditable(true);
    ComboBoxEditor editor = cb.getEditor();
    Component c = editor.getEditorComponent();
    if(c instanceof JTextField) {
      JTextField tf = (JTextField)c;
      tf.setBorder(BorderFactory.createMatteBorder(1,1,1,0,BORDER));
    }
  }
  private static void setPopupBorder(JComboBox cb) {
    Object o = cb.getAccessibleContext().getAccessibleChild(0);
    JComponent c = (JComponent)o;
    c.setBorder(BorderFactory.createMatteBorder(0,1,1,1,BORDER));
  }
  private static DefaultComboBoxModel<String> makeModel() {
    DefaultComboBoxModel<String> m = new DefaultComboBoxModel<>();
    m.addElement("1234");
    m.addElement("5555555555555555555555");
    m.addElement("6789000000000");
    return m;
  }
  public static void main(String[] args) {
//     OceanTheme theme = new OceanTheme() {
//       @Override protected ColorUIResource getSecondary2() {
//         return new ColorUIResource(Color.RED);
//       }
//     };
//     MetalLookAndFeel.setCurrentTheme(theme);

    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowGUI();
      }
    });
  }
  public static void createAndShowGUI() {
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(new ComboBoxUIDemo().makeUI());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}