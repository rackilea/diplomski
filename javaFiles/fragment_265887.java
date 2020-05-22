import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainWindow {
    // Seconda Finestra
    public static void NuovaFinestra (JPanel panel) {
        panel.setLayout(null);
        JButton Ricerca = new JButton("Ricerca");
        Ricerca.setBounds(100, 100, 200, 50);
        panel.add(Ricerca);
        Ricerca.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JFrame FinestradiRicerca = new JFrame("Finestra di Ricerca");
                FinestradiRicerca.setBounds(300, 300, 500, 500);
                //If you don't want to close whole app when closing this windo change it to: JFrame.DISPOSE_ON_CLOSE
                FinestradiRicerca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel riquadroRicerca = new JPanel();
                JTextField ciao;
                JLabel myLabel = new JLabel("Here goes your label text");
                ciao = new JTextField ();
                ciao.setColumns(20);
                riquadroRicerca.add(myLabel);
                riquadroRicerca.add(ciao);
                FinestradiRicerca.add(riquadroRicerca);
                FinestradiRicerca.setVisible(true);
            }
        });
    }

    //Main  
    public static void main(String[] args) {
        //Finestra Principale
        JFrame finestra = new JFrame("Finestra principale");
        finestra.setSize(500, 500);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //JPanel della finestra principale
        JPanel riquadro = new JPanel();
        finestra.add(riquadro);
        finestra.setVisible(true);
        NuovaFinestra(riquadro);
    }
}