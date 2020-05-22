import java.awt.*;
import java.util.Objects;
import javax.swing.*;

public class ComboWithTooltip2 {
    public static void main(String[] args) {
        try {
            // On my system: "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName( ));
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            System.err.println("Can't set look and feel");
            return;
        }
        EventQueue.invokeLater (
            new Runnable() {
                @Override
                public void run() {
                    buildFrame().setVisible(true);
                }
            }
        );
    }

    static JFrame buildFrame() {
        JPanel contentPane = new JPanel();
        BoxLayout layout = new BoxLayout(contentPane, BoxLayout.Y_AXIS);
        contentPane.setLayout(layout);
        contentPane.add(Box.createVerticalStrut(25));
        contentPane.add(createDefaultCombo(true/*enabled*/));
        contentPane.add(Box.createVerticalStrut(25));
        contentPane.add(createTweakedCombo(true/*enabled*/));
        contentPane.add(Box.createVerticalStrut(25));
        contentPane.add(createDefaultCombo(false/*enabled*/));
        contentPane.add(Box.createVerticalStrut(25));
        contentPane.add(createTweakedCombo(false/*enabled*/));
        contentPane.add(Box.createVerticalStrut(25));

        contentPane.add(Box.createVerticalStrut(25));
        contentPane.add(createDefaultCombo2(true));
        contentPane.add(Box.createVerticalStrut(25));
        contentPane.add(createDefaultCombo2(false));
        contentPane.add(Box.createVerticalStrut(25));
        contentPane.add(Box.createVerticalGlue());
        contentPane.setPreferredSize(new Dimension(100, 320));

        JFrame frame = new JFrame();
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    private final static String[] items = new String[]{ "Long text 1234444444444444444444444", "Some more of that long texttttttttttttttttttttt", "The longer the text, the harder to read it becomessssssssssssssssssssssssssssssssssssssss" };

    @SuppressWarnings("serial")
    private static JComboBox<String> createDefaultCombo(boolean enabled) {
        JComboBox<String> comboBoxDefault = new JComboBox<String>(items) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(100,25); // intentionally too small
            }
        };
        comboBoxDefault.setEnabled(enabled);
        return comboBoxDefault;
    }

    @SuppressWarnings("serial")
    private static class JComboBoxTweaked extends JComboBox<String> {
        public JComboBoxTweaked(String[] items) {
            super(items);

            setRenderer (
                new DefaultListCellRenderer() {
                    @Override
                    public void setBounds(int x, int y, int width, int height) {
                        super.setBounds( x, y, width, height );

                        if( width != 0 ) {
                            if( getPreferredSize( ).width > getSize( ).width )
                                JComboBoxTweaked.this.setToolTipText( getText( ) );
                            else
                                JComboBoxTweaked.this.setToolTipText( null );
                        }
                    }
                }
            );
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100,25); // intentionally too small
        }
    };

    private static JComboBox<String> createTweakedCombo(boolean enabled) {
        JComboBox<String> comboBoxTweaked = new JComboBoxTweaked(items);
        comboBoxTweaked.setEnabled(enabled);
        return comboBoxTweaked;
    }

  private static JComboBox<String> createDefaultCombo2(boolean enabled) {
    JComboBox<String> comboBox = new JComboBox<String>(items) {
      @Override public void updateUI() {
        setRenderer(null);
        super.updateUI();
        ListCellRenderer<? super String> renderer = getRenderer();
        setRenderer(new ListCellRenderer<String>() {
          @Override public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
            Component c = renderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            Insets i1 = ((JComponent) c).getInsets();
            Insets i2 = getInsets();
            int availableWidth = getWidth() - i1.top - i1.bottom - i2.top - i2.bottom;
            if (index < 0) {
              int buttonSize = getHeight() - i2.top - i2.bottom;
              availableWidth -= buttonSize;
              JTextField tf = (JTextField) getEditor().getEditorComponent();
              Insets i3 = tf.getMargin();
              availableWidth -= i3.left + i3.right;
            }

            String str = Objects.toString(value, "");
            FontMetrics fm = c.getFontMetrics(getFont());
            setToolTipText(fm.stringWidth(str) > availableWidth ? str : null);
            return c;
          }
        });
      }
    };
    comboBox.setEnabled(enabled);
    return comboBox;
  }
}