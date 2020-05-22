import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.*;

public class TextPaneMRE extends JFrame
{
    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            public void run()
            {
                TextPaneMRE frame = new TextPaneMRE();
                frame.setVisible(true);
            }
        });
    }

    /**
     * Create the frame.
     */
    public TextPaneMRE()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JTextPane textPane = new JTextPane();
        textPane.setContentType( "text/html" );
        textPane.setText("<b>I WHAT?</b>");
        textPane.setEditable(false);
        add(textPane, BorderLayout.CENTER);

        SimpleAttributeSet italic = new SimpleAttributeSet();
        StyleConstants.setItalic(italic, true);

        JButton btnInsertTheText = new JButton("Insert the text");
        btnInsertTheText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    StyledEditorKit editorKit = (StyledEditorKit)textPane.getEditorKit();
                    StyledDocument doc = (StyledDocument)textPane.getDocument();
                    String text = "SAID ";
                    doc.insertString(3, text, editorKit.getInputAttributes());
                    doc.setCharacterAttributes(3, text.length(), italic, false);
                    System.out.println("Text Pane: " + textPane.getText());
                }
                catch (BadLocationException exc)
                {
                    // TODO Auto-generated catch block
                    exc.printStackTrace();
                }
            }
        });

        add(btnInsertTheText, BorderLayout.NORTH);
        System.out.println("Text Pane: " + textPane.getText());
    }
}