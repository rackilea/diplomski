import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.text.*;

public class ScrollControl implements AdjustmentListener
{
    private JScrollBar scrollBar;
    private JTextComponent textComponent;
    private int previousExtent = -1;

    public ScrollControl(JScrollPane scrollPane)
    {
        Component view = scrollPane.getViewport().getView();

        if (! (view instanceof JTextComponent))
            throw new IllegalArgumentException("Scrollpane must contain a JTextComponent");

        textComponent = (JTextComponent)view;

        scrollBar = scrollPane.getVerticalScrollBar();
        scrollBar.addAdjustmentListener( this );
    }

    @Override
    public void adjustmentValueChanged(final AdjustmentEvent e)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                checkScrollBar(e);
            }
        });
    }

    private void checkScrollBar(AdjustmentEvent e)
    {
        //  The scroll bar model contains information needed to determine the
        //  caret update policy.

        JScrollBar scrollBar = (JScrollBar)e.getSource();
        BoundedRangeModel model = scrollBar.getModel();
        int value = model.getValue();
        int extent = model.getExtent();
        int maximum = model.getMaximum();
        DefaultCaret caret = (DefaultCaret)textComponent.getCaret();

        //  When the size of the viewport changes there is no need to change the
        //  caret update policy.

        if (previousExtent != extent)
        {
            //  When the height of a scrollpane is decreased the scrollbar is
            //  moved up from the bottom for some reason. Reposition the
            //  scrollbar at the bottom

            if (extent < previousExtent
            &&  caret.getUpdatePolicy() == DefaultCaret.UPDATE_WHEN_ON_EDT)
            {
                scrollBar.setValue( maximum );
            }

            previousExtent = extent;
            return;
        }

        //  Text components will not scroll to the bottom of a scroll pane when
        //  a bottom inset is used. Therefore the location of the scrollbar,
        //  the height of the viewport, and the bottom inset value must be
        //  considered when determining if the scrollbar is at the bottom.

        int bottom = textComponent.getInsets().bottom;

        if (value + extent + bottom < maximum)
        {
            if (caret.getUpdatePolicy() != DefaultCaret.NEVER_UPDATE)
                caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        }
        else
        {
            if (caret.getUpdatePolicy() != DefaultCaret.UPDATE_WHEN_ON_EDT)
            {
                caret.setDot(textComponent.getDocument().getLength());
                caret.setUpdatePolicy(DefaultCaret.UPDATE_WHEN_ON_EDT);
            }
        }
    }

    private static void createAndShowUI()
    {
        JPanel center = new JPanel( new GridLayout(1, 2) );
        String text = "1\n2\n3\n4\n5\n6\n7\n8\n9\n0\n";

        final JTextArea textArea = new JTextArea();
        textArea.setText( text );
        textArea.setEditable( false );
        center.add( createScrollPane( textArea ) );
        System.out.println(textArea.getInsets());

        final JTextPane textPane = new JTextPane();
        textPane.setText( text );
        textPane.setEditable( false );
        center.add( createScrollPane( textPane )  );
        textPane.setMargin( new Insets(5, 3, 7, 3) );
        System.out.println(textPane.getInsets());

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(center, BorderLayout.CENTER);
        frame.setSize(500, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Timer timer = new Timer(2000, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    Date now = new Date();
                    textArea.getDocument().insertString(textArea.getDocument().getLength(), "\n" + now.toString(), null);
                    textPane.getDocument().insertString(textPane.getDocument().getLength(), "\n" + now.toString(), null);
                }
                catch (BadLocationException e1) {}
            }
        });
        timer.start();
    }

    private static JComponent createScrollPane(JComponent component)
    {
        JScrollPane scrollPane = new JScrollPane(component);
        new ScrollControl( scrollPane );

        return scrollPane;
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowUI();
            }
        });
    }
}