import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 * This class demonstrates overriding the combo box renderer so that
 * a given object can be displayed in the combo box in a particular way.
 * In this demo, the class java.util.AbstractMap.SimpleEntry<K,V> will be used
 * as the object and only the value will be shown in the combo box. The
 * {@link SimpleEntryRenderer} class is used to override the standard renderer
 * to do this.
 *
 */
@SuppressWarnings("serial")
public class ComboBoxKeyValueDemo extends JFrame {

    private JPanel          contentPanel    = null;
    private JTextField      fKeyValue       = new JTextField();
    private GridBagLayout   gridBagLayout   = new GridBagLayout();
    private JLabel          lComboBox       = new JLabel();
    private JLabel          lKeyValue       = new JLabel();

    private JComboBox<SimpleEntry<Integer, String>> fComboBox = new JComboBox<>();

    /**
     * The SimpleEntryRenderer class is used to override the component
     * renderer of the combo box and display the SimpleEntry<Integer,String>
     * as the String value.  Normally, the display would appear as "K=V" 
     *
     */
    public class SimpleEntryRenderer extends BasicComboBoxRenderer {
      @SuppressWarnings({ "rawtypes", "unchecked" })
      @Override
      public Component getListCellRendererComponent(JList list, Object value,
          int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected,
            cellHasFocus);
        if (value != null) {
          AbstractMap.SimpleEntry<Integer, String> item = (AbstractMap.SimpleEntry<Integer, String>) value;
          setText(item.getValue());
        }
        return this;
      }  
    }

    public ComboBoxKeyValueDemo() {

        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            // Initialize the fields
            jbInit();
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            showCenterScreen(this);
            setCursor(Cursor.getDefaultCursor());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }   
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void jbInit() {

        contentPanel = (JPanel) this.getContentPane();
        contentPanel.setLayout(gridBagLayout);

        lComboBox.setText("Select entry:");

        // Fill the comboBox with SimpleEntry objects
        fComboBox.addItem(new SimpleEntry<Integer, String>(1, "-"));
        fComboBox.addItem(new SimpleEntry<Integer, String>(2, "X"));
        fComboBox.addItem(new SimpleEntry<Integer, String>(3, "Y"));
        fComboBox.setMaximumRowCount(3);

        // This is the important bit. The renderer determines how the 
        // the combo box displays the object it has selected. Here
        // we'll replace the renderer with a custom one that will only
        // display the value of the SimpleEntry object.
        fComboBox.setRenderer(new SimpleEntryRenderer());

        // For the demo, when the value of the comboBox changes, 
        // display the Key - Value in another field.
        fComboBox.addActionListener(e -> {
            JComboBox c = (JComboBox) e.getSource();
            SimpleEntry<Integer, String> item = (SimpleEntry<Integer, String>) c.getSelectedItem();
            fKeyValue.setText("Item " + item.getKey() + " : " + item.getValue());
        });

        lKeyValue.setText("Key : Value");
        fKeyValue.setColumns(10);
        fKeyValue.setEditable(false);

        fComboBox.setSelectedIndex(0);  // Will fire event to update the fKeyValue field.

        // Layout the fields
        contentPanel.add(lComboBox,    new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 5, 2, 5), 0, 0));
        contentPanel.add(fComboBox,    new GridBagConstraints(1, 0, 1, 1, 0.5, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(5, 2, 2, 5), 0, 0));

        contentPanel.add(lKeyValue,     new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(2, 5, 2, 5), 0, 0));
        contentPanel.add(fKeyValue,     new GridBagConstraints(1, 1, 1, 1, 0.5, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(2, 2, 2, 5), 0, 0));
    }


    public static void main(String[] args) {
      new ComboBoxKeyValueDemo();
    }

    /**
     *  Show in the center of the screen.
     *  (pack, set location and set visibility)
     *  @param window Window to position
     */
    public static void showCenterScreen(Window window) {
        positionScreen (window);
        window.setVisible(true);
        window.toFront();
    }   //  showCenterScreen

    /**
     *  Position window in center of the screen
     *  @param window Window to position
     */
    public static void positionScreen (Window window)
    {
        window.pack();
        // take into account task bar and other adornments
        GraphicsConfiguration config = window.getGraphicsConfiguration();
        Rectangle bounds = config.getBounds();
        Dimension sSize = bounds.getSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(config);
        sSize.width -= (insets.left + insets.right);
        sSize.height -= (insets.top + insets.bottom);

        Dimension wSize = window.getSize();
        //  fit on window
        if (wSize.height > sSize.height)
            wSize.height = sSize.height;
        if (wSize.width > sSize.width)
            wSize.width = sSize.width;
        window.setSize(wSize);
        //  Center
        int x = (sSize.width - wSize.width) / 2;
        int y = (sSize.height - wSize.height) / 2;
        //
        window.setLocation(bounds.x + x + insets.left, bounds.y + y + insets.top);
    }   //  positionScreen
}