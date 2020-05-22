import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.EventObject;

import javax.swing.DefaultCellEditor;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellEditor;

public class JTableWithCtrlZ {
    private JTableWithCtrlZ( ) {}

    @SuppressWarnings("serial")
    private static JTable createTable( ) {
        return new JTable( 10, 10 ) {
            @Override
            public TableCellEditor getDefaultEditor( Class<?> columnClass ) {
                return new DefaultCellEditor( new JTextField( ) ) {
                    @Override
                    public boolean isCellEditable( EventObject anEvent ) {
                        if( anEvent instanceof KeyEvent ) {
                            KeyEvent ke = (KeyEvent) anEvent;
                            if( ( ke.getKeyCode( ) == KeyEvent.VK_Z || ke.getKeyCode( ) == KeyEvent.VK_Y ) &&
                                ( ke.getModifiersEx( ) & KeyEvent.CTRL_DOWN_MASK ) == KeyEvent.CTRL_DOWN_MASK )
                                return false;
                        }

                        return super.isCellEditable( anEvent );
                    }
                };
            }
        };
    }

    public static JFrame createFrame( ) {
        JPanel p = new JPanel( );
        p.setLayout( new BorderLayout( ) );
        p.add( new JScrollPane( createTable( ) ), BorderLayout.CENTER );
        p.setPreferredSize( new Dimension( 250, 150 ) );

        JFrame f = new JFrame( );
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        f.setContentPane( p );
        f.pack( );
        return f;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater( new Runnable() {
            @Override
            public void run() {
                createFrame( ).setVisible( true );
            }
        });
    }
}