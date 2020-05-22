/*
 * Created on 12.09.2012
 *
 */
package layout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class MigLayoutNested extends JFrame {


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            private MigLayoutNested frame;

            public void run() {
                try {
                    frame = new MigLayoutNested();
                    frame.pack();
//                    frame.setSize(frame.getWidth(), frame.getHeight()* 2);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private JPanel contentPane;
    private JPanel mainPanel;
    private JPanel optionPanel;
    private JButton btnUploadImages;
    private JLabel thumbnailLabel;
    private JTextArea textArea;
    private JPanel checkboxPanel;
    private final Action action = new SwingAction();

    /**
     * Create the frame.
     */
    public MigLayoutNested() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = (JPanel) getContentPane(); //new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new CardLayout(0, 0));

        mainPanel = new JPanel();
        contentPane.add(mainPanel, "name_329556913535654");

        mainPanel.setLayout(new MigLayout("debug", 
                "[grow, fill][grow, pref:pref:n]" 
               , "[grow, fill][][][][][][][grow]"
                ));

        // stand-in to simulate a row-spanning all-growing component
        optionPanel = new JPanel();
        ((FlowLayout) optionPanel.getLayout()).setAlignment(JLabel.RIGHT);
        JLabel option = new JLabel("just some label so we see the trailing corner, long enough");
        optionPanel.add(option);
        optionPanel.setBackground(Color.YELLOW);
        mainPanel.add(optionPanel, "cell 1 0 1 5, grow");

        // the panel to dynamically add components to  
        // expected behaviour is to wrap on revalidate if needed
        // not working with FlowLayout, but looks half-way fine
        // with Rob's WrapLayout
        checkboxPanel = new JPanel(new WrapLayout()); 
        checkboxPanel.setBackground(Color.green);
        JLabel lblSites = new JLabel("Sites");
        checkboxPanel.add(lblSites);
        mainPanel.add(checkboxPanel, "cell 0 0");

        JLabel lblPicture = new JLabel("Picture");
        mainPanel.add(lblPicture, "cell 0 1");

        thumbnailLabel = new JLabel("thumb");
        mainPanel.add(thumbnailLabel, "cell 0 3");
        textArea = new JTextArea(10, 10);
        mainPanel.add(textArea, "cell 0 4");

        btnUploadImages = new JButton("Upload Images");
        btnUploadImages.setAction(action);
        mainPanel.add(btnUploadImages, "cell 0 6");


    }
    private class SwingAction extends AbstractAction {
        public SwingAction() {
            putValue(NAME, "Add checkbox");
            putValue(SHORT_DESCRIPTION, "Some short description");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            JCheckBox box = new JCheckBox();
            box.setName("Foobar!");
            checkboxPanel.add(box);
            checkboxPanel.revalidate();
        }
    }
}