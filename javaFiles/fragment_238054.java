import java.awt.*;
import javax.swing.*;

public class GridBagLayoutExample {

    private final int hGap = 5;
    private final int vGap = 5;

    private GridBagConstraints gbc;

    public GridBagLayoutExample () {
        gbc = new GridBagConstraints ();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;   
        gbc.insets = new Insets( hGap, vGap, hGap, vGap ); 
    }

    private void displayGUI () {
        JFrame frame = new JFrame ( "GridBagLayout Example" );
        frame.setDefaultCloseOperation ( JFrame.DISPOSE_ON_CLOSE );

        JPanel contentPane = getPanel ( Color.WHITE );
        contentPane.setLayout ( new GridBagLayout () );

        JPanel blackPanel = getPanel ( Color.BLACK );
        addComp ( contentPane, blackPanel, 0, 0, 1, 1
                            , GridBagConstraints.BOTH, 0.7, 0.7 );

        JPanel grayPanel = getPanel ( Color.GRAY );
        addComp ( contentPane, grayPanel, 0, 1, 1, 1
                            , GridBagConstraints.BOTH, 0.7, 0.3 );

        JPanel bluePanel = getPanel ( Color.BLUE );
        addComp ( contentPane, bluePanel, 1, 0, 1, 2
                            , GridBagConstraints.BOTH, 0.3, 1.0 );

        frame.setContentPane ( contentPane );
        frame.pack ();
        frame.setLocationByPlatform ( true );
        frame.setVisible ( true );
    }

    private void addComp(JPanel panel, JComponent comp
                                , int x, int y, int gWidth
                                    , int gHeight, int fill
                                        , double weightx, double weighty) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = gWidth;
        gbc.gridheight = gHeight;
        gbc.fill = fill;
        gbc.weightx = weightx;
        gbc.weighty = weighty;      

        panel.add(comp, gbc);
    }

    private JPanel getPanel ( Color bColor ) {
        JPanel panel = new JPanel();
        panel.setOpaque ( true );
        panel.setBackground ( bColor );

        return panel;
    }

    public static void main ( String [] args ) {
        Runnable runnable = new Runnable () {
            @Override
            public void run () {
                new GridBagLayoutExample ().displayGUI ();
            }
        };
        EventQueue.invokeLater ( runnable );
    }
}