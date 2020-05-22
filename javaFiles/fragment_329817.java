package popupmenutest;

import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class PopupMenuTest implements WindowFocusListener
{

    public PopupMenuTest()
    {

        frame = new JFrame();
        frame.setSize(800, 600);
        popupMenu = new JPopupMenu();
        JTextArea annotationTextArea = new JTextArea(5,20);
        JScrollPane scrollPane = new JScrollPane(annotationTextArea); 
        popupMenu.setPreferredSize(new Dimension(300, 120));
        annotationTextArea.setText("Dies hier ist ein Blindtext zum Testen von Textausgaben. Wer diesen Text liest, ist selbst schuld. Der Text gibt lediglich den Grauwert der Schrift an. Ist das wirklich so? "
            + " Ist es gleichgÃ¼ltig, ob ich schreibe: Dies ist ein Blindtext oder Huardest gefburn? Kjift â€“ mitnichten! Ein Blindtext bietet mir wichtige Informationen. An ihm messe ich die Lesbarkeit einer Schrift, "
            + "ihre Anmutung, wie harmonisch ");

        annotationTextArea.setLineWrap(true);
        annotationTextArea.setWrapStyleWord(true);
        annotationTextArea.invalidate();
        scrollPane.setVisible(true);
        popupMenu.setLocation(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);
        popupMenu.add(scrollPane);
        popupMenu.pack();
        frame.add(popupMenu);
        frame.addWindowFocusListener(this);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void windowGainedFocus(WindowEvent e)
    {

    }

    @Override
    public void windowLostFocus(WindowEvent e)
    {
        popupMenu.setVisible(false);

    }
    private JPopupMenu popupMenu;
    private JFrame frame;
}