import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class TextPaneAttributes extends JPanel
{

    public TextPaneAttributes()
    {
        setLayout( new BorderLayout() );

        JTextPane textPane = new JTextPane();
        textPane.setText( "one\ntwo\nthree\nfour\nfive\nsix\nseven\neight" );

//      DefaultHighlighter highlighter =  (DefaultHighlighter)textPane.getHighlighter();
//      highlighter.setDrawsLayeredHighlights(false);

        //  Define some character and paragraph attributes

        SimpleAttributeSet keyWord = new SimpleAttributeSet();
        StyleConstants.setBold(keyWord, true);

        SimpleAttributeSet green = new SimpleAttributeSet();
        StyleConstants.setForeground(green, Color.GREEN);

        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);

        SimpleAttributeSet left = new SimpleAttributeSet();
        StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);

        //  Change attributes on some existing text

        StyledDocument doc = textPane.getStyledDocument();
        doc.setCharacterAttributes(0, 3, keyWord, false);
        doc.setCharacterAttributes(8, 5, green, true);
        doc.setParagraphAttributes(20, 1 , center, false);

        //  Add some text with attributes

        try
        {
            doc.insertString(doc.getLength(), "\nNormal text", null);
            doc.insertString(doc.getLength(), "\nGreen text centered", green);
            doc.setParagraphAttributes(doc.getLength(), 1 , center, false);
            doc.insertString(doc.getLength(), "\nKeyword text", keyWord);
            doc.setParagraphAttributes(doc.getLength(), 1 , left, false);

            //  Newly typed text at the end of the document will inherit the
            //  "keyword" attributes unless we remove the attributes

            textPane.setCaretPosition(doc.getLength());
            textPane.getInputAttributes().removeAttributes(keyWord);
        }
        catch(Exception e) {}

        //  Add text pane to frame

        JScrollPane scrollPane = new JScrollPane( textPane );
        scrollPane.setPreferredSize( new Dimension( 200, 250 ) );
        add( scrollPane );

        //  Create a Button panel

        JPanel buttons = new JPanel();
        add(buttons, BorderLayout.PAGE_END);

        //  Add a Bold button

        JButton bold = new JButton( new StyledEditorKit.BoldAction() );
        buttons.add( bold );

        //  Add Right Alignment button

        JButton right = new JButton( new StyledEditorKit.AlignmentAction("Align Right", StyleConstants.ALIGN_RIGHT) );
        buttons.add( right );
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TextPaneAttributes());
        frame.pack();
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater( () -> createAndShowGUI() );
/*
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
*/
    }
}