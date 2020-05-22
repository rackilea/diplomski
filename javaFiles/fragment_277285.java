import javax.swing.*;
import java.net.*;
import java.awt.event.*;

public class Main
{
    public static JDialog aboutWindow;

    public static void about () {
    Main.aboutWindow = new JDialog();
    Main.aboutWindow.setTitle("About kingfisher a0.0.3");
    Main.aboutWindow.setSize(300,600);
    Main.aboutWindow.setModal(true);
        JMenuBar menubar = new JMenuBar();
            JMenu control = new JMenu("Control");
                JMenuItem quit = new JMenuItem("quit");
                    quit.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent event) {
                            Main.aboutWindow.setVisible(false);
                            }
                        }
                    );
                control.add(quit);
            menubar.add(control);
        Main.aboutWindow.add(menubar);
    JLabel name = new JLabel("kingfisher");
    Main.aboutWindow.add(name);
    }

    public static void main (String args[]){
    //Defined window dimensions
    JFrame controlpanel = new JFrame();
    controlpanel.setTitle("kingfisher a0.0.3");
    controlpanel.setSize(500,400);
    controlpanel.add(new JLabel("The angels have the blue box"));
        JMenuBar menubar = new JMenuBar();
        //defining menu groups
            JMenu windows = new JMenu("Windows");
                JCheckBoxMenuItem chat = new JCheckBoxMenuItem("Chat");
                JCheckBoxMenuItem filetransfer = new JCheckBoxMenuItem("Filetransfer");
                JCheckBoxMenuItem settings = new JCheckBoxMenuItem("Settings");
                windows.add(chat);
                windows.add(filetransfer);
                windows.add(settings);
            JMenu control = new JMenu("Control");
                JMenuItem quit = new JMenuItem("Quit");
                quit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        System.exit(0);
                        }
                    }
                );
                control.add(quit);
            JMenu help = new JMenu("Help");
                JMenuItem support = new JMenuItem("Support");
                JMenuItem about = new JMenuItem("About");
                    about.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent event) {
                            //HERE!
                            Main.aboutWindow.setVisible(true);
                            }
                        }
                    );
                help.add(support);
                help.add(about);
            menubar.add(control);
            menubar.add(windows);
            menubar.add(help);
        controlpanel.setJMenuBar(menubar);
    controlpanel.setVisible(true);
    };
};