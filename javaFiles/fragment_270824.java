import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;


public class ImageChangeDemo extends JFrame {
    public static void main(String args[]) {
        //comment out the code below to try in Metal L&F
        try {
            for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.
                    getInstalledLookAndFeels()) {
                if("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImageChangeDemo().setVisible(true);
            }
        });
    }

    public ImageChangeDemo(){
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        JScrollPane pane = new javax.swing.JScrollPane();
        JTable table = new javax.swing.JTable();
        table.setAutoCreateRowSorter(true);
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"a", "q", "h", "v"},
                {"b", "m", "l", "h"},
                {"d", "c", "a", "d"},
                {"j", "o", "y", "e"}
            },
            new String [] {
                "Col 1", "Col 2", "Col 3", "Col 4"
            }
        ) {
            Class[] types = new Class [] {
                String.class, String.class, String.class, String.class
            };
            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        pane.setViewportView(table);
        this.add(pane);


        pack();
        //set renderer after pack so header row has correct default height
        table.getTableHeader().setDefaultRenderer(new ImageRenderer(table));


    }

    public class ImageRenderer extends DefaultTableCellRenderer{
        TableCellRenderer orig;
        private final ImageIcon icon = new ImageIcon(
                    ImageChangeDemo.class.getResource("/resources/exclamation-icon.png"));;
        private JPanel jp = new JPanel(new StackLayout());
        private final JLabel pic = new JLabel(icon);
        { //extra initialization for PIC
            pic.setHorizontalAlignment(JLabel.LEADING); //so it isn't centered in stack layout
        }

        ImageRenderer(JTable table){
            orig = table.getTableHeader().getDefaultRenderer();
        }

        @Override
        public Component getTableCellRendererComponent(final JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = 
                    orig.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);
            if(true){
                int width  = table.getColumnModel().getColumn(column).getWidth();
                int height = table.getTableHeader().getSize().height;
                System.out.println("height"+height);

                jp.removeAll();                //clean the JPanel

                //move text in label to the left so it isn't covered by the icon
                if(c instanceof JLabel){
                    JLabel l = (JLabel) c;
                    l.setPreferredSize(new Dimension(width, height));

                    FontMetrics fontMetrics = l.getFontMetrics(l.getFont());
                    int sizeOfSpace = fontMetrics.charWidth(' ');
                    int numSpaces = (int)Math.round(icon.getIconWidth() / (double)sizeOfSpace);
                    StringBuilder sb = new StringBuilder();
                    for(int i = 0; i < numSpaces; i++)
                        sb.append(' ');

                    //account for HTML in header messages
                    if(l.getText().toLowerCase().startsWith("<html>")){
                        l.setText(  l.getText().substring(0, "<html>".length()) +
                                    sb.toString() +
                                    l.getText().substring("<html>".length()));
                    }
                    else
                        l.setText(sb.toString()+l.getText());
                }


                //Add components to the JPanel & return it.
                jp.add(c, StackLayout.BOTTOM);  //will contain modifications for spacing.
                jp.add(pic, StackLayout.TOP);
                return jp;

            }
            else
                return c;
        }
    }
}