import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class Terminal1 implements KeyListener
{

    static CustomFrame1 frame = new CustomFrame1(Types.TERMINAL);

    JTextArea log = new JTextArea();
    JTextField field = new JTextField();

    public void setVisible(boolean bool)
    {
        frame.setVisible(bool);
    }

    public void addKeyListener(KeyListener listener)
    {
        frame.addKeyListener(listener);
    }

    public void setLogText(String str)
    {
        log.setText(log.getText() + str + "\n");
    }

    public void setLocation(int x, int y)
    {
        frame.setLocation(x, y);
    }

    public void setLocationRelativeTo(Component c)
    {
        frame.setLocationRelativeTo(c);
    }

    int index = 0;

    public void slowPrint(final String text)
    {
        frame.slowPrint(text, log);
    }

    public void slowPrintAndClear(final String text, boolean andQuit)
    {
        frame.slowPrintAndClear(text, log, andQuit);
    }

    public Terminal1()
    {
        try
        {

            JScrollPane pane = new JScrollPane();
            JScrollBar scrollBar = pane.getVerticalScrollBar();

            scrollBar.setUI(new ScrollBarUI());
            pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            pane.setViewportView(log);

            frame.add(field);
            frame.add(pane);

            log.setBackground(Color.BLACK);
            log.setForeground(Color.WHITE);
            log.setWrapStyleWord(true);
            log.setLineWrap(true);
            pane.setBounds(4, 20 + 4, frame.getWidth() - 8, frame.getHeight() - 50);
            pane.setBorder(null);
            log.setEditable(false);
            log.setCaretColor(Color.BLACK);

            field.setBackground(Color.BLACK);
            field.setForeground(Color.WHITE);
            field.setBounds(2, frame.getHeight() - 23, frame.getWidth() - 5, 20);
            field.setHighlighter(null);
            field.setCaretColor(Color.BLACK);
            field.addKeyListener(this);
            field.setText("  >  ");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void dumpToLog()
    {
        log.setText(log.getText() + field.getText() + "\n");
        field.setText("  >  ");
    }

    public void setVariables(Types type)
    {
        switch (type)
        {
        case TERMINAL:
            this.type = Types.TERMINAL;
            break;
        case LOGINTERMINAL:
            this.type = Types.LOGINTERMINAL;
            break;
        default:
            this.type = Types.TERMINAL;
            break;
        }
    }

    Types type;

    public void keyPressed(KeyEvent e)
    {
        int i = e.getKeyCode();

        String text1 = "  >  ";
        String text2 = field.getText().replaceFirst(text1, "");
        String text2_1 = text2.trim();
        String text = text1 + text2_1;

        if (type == Types.TERMINAL)
        {

        }
        else if (type == Types.LOGINTERMINAL)
        {
            if (i == KeyEvent.VK_ENTER && field.isFocusOwner())
            {
                if (text.startsWith("  >  register") || text.startsWith("  >  REGISTER"))
                {
                    if (!(text.length() == 13))
                    {
                        dumpToLog();
                        slowPrint("Registry not available at this current given time.\n");
                        // TODO: Create registry system.
                        new Notification1("test");
                    }
                    else
                    {
                        dumpToLog();
                        slowPrint("\nInformation:\n" + "Registers a new account.\n\n" + "Usage:\n" + "register <username>\n");
                    }
                }
                else
                {
                    System.out.println("start |" + text + "| end");
                    dumpToLog();
                    slowPrint("Unknown command.\n");
                }
            }
        }
        else
        {
            // SETUP CODE FOR NOTIFICATION ERROR AGAIN
        }

        if (field.isFocusOwner() && i == KeyEvent.VK_LEFT || i == KeyEvent.VK_RIGHT)
        {
            e.consume();
        }

        if (!field.getText().startsWith("  >  "))
        {
            field.setText("  >  ");
        }
    }

    public void keyReleased(KeyEvent e)
    {
    }

    public void keyTyped(KeyEvent e)
    {
    }

}