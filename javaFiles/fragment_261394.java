import java.awt.*;
import javax.swing.*;

public class ScrollPaneTest5
{
    private JFrame          frame;
    private JScrollPane  scrollPane;
    private JTextArea       textArea;

    public static void main( String[] args ) throws Exception
    {
        UIManager.setLookAndFeel( "com.sun.java.swing.plaf.windows.WindowsLookAndFeel" );
        new ScrollPaneTest5();
    }

    public ScrollPaneTest5()
    {
        configureUi();

        SwingUtilities.invokeLater( new Runnable() {
            @Override public void run() {
                frame.setVisible( true );
            }
        } );
    }

    private void configureUi()
    {
        textArea = new JTextArea();
        textArea.setWrapStyleWord( true );
        textArea.setLineWrap( true );
//        textArea.setOpaque( false );
        textArea.setText( "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor "
                + "invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo "
                + "duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor "
                + "sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor "
                + "invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et "
                + "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum "
                + "dolor sit amet." );

        scrollPane = new JScrollPane();
//        scrollPane.setViewportView( textArea );
        scrollPane.setLocation( 50, 50 );
        scrollPane.setSize( 200, 200 );

        frame = new JFrame( getClass().getSimpleName() );
        frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        frame.setLayout( null );
        frame.setSize( 340, 380 );
        frame.setLocationRelativeTo( null );

        frame.add( scrollPane );



        JViewport viewport = new JViewport()
        {
            public void paintComponent(Graphics g)
            {
                super.paintComponent(g);

                g.setColor( Color.BLUE );
                g.drawArc( 100, 100, 80, 80, 0, 360);
            }
        };

        textArea.setOpaque( false );
        viewport.setView(textArea);
        scrollPane.setViewport( viewport );
    }
}