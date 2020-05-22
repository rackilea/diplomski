import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.DefaultCaret;

public class TestGUI {

    private static JFrame mainframe;

    private static JPanel newGamePanel;
    private static JPanel loadGamePanel;
    private static JPanel panelContainer;

    final static String NEWGAME = "New Game";
    final static String LOADGAME = "Load Game";

    public TestGUI() {
        // do nothing
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {  
            public void run() {
                System.setProperty("awt.useSystemAAFontSettings", "on");
                TestGUI.createGUI();
            }
        }); 
    }

    public static void createGUI() {
        mainframe = new JFrame("Login to Test");

        newGamePanel = new JPanel();
        loadGamePanel = new JPanel();
        panelContainer = new JPanel();
        panelContainer.setLayout(new CardLayout());

        JPanel basePanel = new JPanel();

        final JPanel statusPanel = new JPanel();

        JButton quitButton = new JButton("Quit");

        JPanel countryDesc = generateContentPanel("Country Description: ", new JTextArea());

        ((JComponent) mainframe.getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        newGamePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GREEN, 1), BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        mainframe.getContentPane().setLayout(new BoxLayout(mainframe.getContentPane(), BoxLayout.Y_AXIS));
        newGamePanel.setLayout(new BoxLayout(newGamePanel, BoxLayout.X_AXIS));
        newGamePanel.setFocusable(true);
        JPanel newGameLeft = new JPanel();
        newGameLeft.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        newGameLeft.setLayout(new BoxLayout(newGameLeft, BoxLayout.Y_AXIS));

        statusPanel.setLayout(new FlowLayout(0, 25, 0));
        statusPanel.setPreferredSize(new Dimension(100, 20));
        statusPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 0), BorderFactory.createEmptyBorder(2, 0, 0, 0)));

        basePanel.setLayout(new FlowLayout(1, 50, 0));
        basePanel.add(quitButton);      

        quitButton.setPreferredSize(new Dimension(120, 40));
        quitButton.setMnemonic(KeyEvent.VK_Q);
        quitButton.setToolTipText("Closes the application");

        newGameLeft.add(countryDesc);

        newGamePanel.add(newGameLeft);

        JLabel temporary = new JLabel("This functionality is in development.");
        loadGamePanel.add(temporary);

        panelContainer.add(newGamePanel, NEWGAME);
        panelContainer.add(loadGamePanel, LOADGAME);
        mainframe.add(panelContainer);
        mainframe.add(Box.createVerticalStrut(5));
        mainframe.add(statusPanel);
        mainframe.add(Box.createVerticalStrut(5));
        mainframe.add(basePanel);

        mainframe.setDefaultCloseOperation(
                WindowConstants.DO_NOTHING_ON_CLOSE);

        mainframe.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }       
        });

        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        mainframe.pack();
        mainframe.setLocationRelativeTo(null);
        mainframe.setVisible(true);
        CardLayout cl = (CardLayout) (panelContainer.getLayout());
        cl.show(panelContainer, NEWGAME);
        newGamePanel.requestFocusInWindow();
    }

    public static JPanel generateContentPanel(String name, JComponent fieldType) {
        JPanel result = new JPanel();
        result.setLayout(new FlowLayout(0, 10, 0));

        JLabel label = new JLabel(name);        
        JScrollPane scrollingResult = null;
        if(fieldType instanceof JTextArea) {
            fieldType = new JTextArea(1, 1);
            //fieldType.setPreferredSize(new Dimension(200, 100));
            //fieldType.setMaximumSize(new Dimension(200, 100));
            fieldType.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            DefaultCaret caret = (DefaultCaret) ((JTextArea) fieldType).getCaret();
            caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
            ((JTextArea) fieldType).setFont(new JTextField().getFont());
            ((JTextArea) fieldType).setLineWrap(true);
            ((JTextArea) fieldType).setWrapStyleWord(true);
            scrollingResult = new JScrollPane(fieldType);
            scrollingResult.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            scrollingResult.setPreferredSize(new Dimension(200, 100));
        }

        result.add(label);
        result.add(Box.createHorizontalGlue());
        if(null == scrollingResult) {
            result.add(fieldType);
        } else {
            result.add(scrollingResult);
        }

        return result;
    }

}