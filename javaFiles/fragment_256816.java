import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class humev extends JFrame implements ActionListener {

    private static final int larghezza = 1300;
    private static final int altezza = 1000;
    private static final String nome = "Human Evolution";

    private final JLabel lab;
    private final JButton gioca;
    private final JPanel pang;

    public humev() {
        super(nome);

        pang = new JPanel();
        //pang.setLayout(new FlowLayout()); // use appropriate layout .for example flowlayout.since flowlayout is default layout for jpanel you can avoid it.but don't use null
        gioca = new JButton("Gioca!");
        gioca.addActionListener(this);
        lab = new JLabel("lable");

        pang.add(gioca);
        pang.add(lab);
        add(pang); // add pang panel to frame
        Dimension dim_finestra = new Dimension(larghezza, altezza);

        setPreferredSize(dim_finestra);
        setMaximumSize(dim_finestra);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); 
        pack();

    }

    public static void main(String[] args) {
        humev humev = new humev();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gioca) {
            lab.setText("Gioco avviato con successo!");
        }
    }
}