import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class SelectWordAction extends TextAction
{
    public SelectWordAction()
    {
        super("Select Word");
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JTextComponent target = getTextComponent(e);

        if (target != null)
        {
            int offset = target.getCaretPosition();
            beginWord(target, offset);
            endWord(target, offset);
        }
    }

    private void beginWord(JTextComponent target, int offset)
    {
        try
        {
            boolean keepSearching = true;
            int beginOffset = Utilities.getWordStart(target, offset);

            while (beginOffset > 1 && keepSearching)
            {
                String previousCharacter = target.getText(beginOffset - 1, 1);

                if ("_".equals(previousCharacter))
                    beginOffset = Utilities.getWordStart(target, beginOffset - 2);
                else
                    keepSearching = false;
            }

            target.setCaretPosition(beginOffset);
        }
        catch (BadLocationException bl)
        {
            UIManager.getLookAndFeel().provideErrorFeedback(target);
        }
    }

    private void endWord(JTextComponent target, int offset)
    {
        try
        {
            int length = target.getDocument().getLength() - 2;
            boolean keepSearching = true;
            int endOffset = Utilities.getWordEnd(target, offset);

            while (endOffset < length && keepSearching)
            {
                String nextCharacter = target.getText(endOffset, 1);

                if ("_".equals(nextCharacter))
                    endOffset = Utilities.getWordEnd(target, endOffset + 1);
                else
                    keepSearching = false;
            }

            target.moveCaretPosition(endOffset);
        }
        catch (BadLocationException bl)
        {
            UIManager.getLookAndFeel().provideErrorFeedback(target);
        }
    }


    private static void createAndShowGUI()
    {
        JTextPane textPane = new JTextPane();

        Action action = new SelectWordAction();
        textPane.getActionMap().put("select-word", action);

        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new JScrollPane( textPane ) );
        frame.setLocationByPlatform( true );
        frame.setSize(300, 300);
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