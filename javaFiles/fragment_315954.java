import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class fenetre extends JFrame implements ActionListener{
    JPanel pan=new JPanel (new FlowLayout());                   //  instancier un  objet jpanel qui contiendra nos composents 
    private JButton nouveau_utilisateur ;
    private JButton identification;

    // le constructeur 
    public fenetre (){

        setTitle("la reconnaissance de la siganteur manuscrite ");        // la taille de la fenetre 
        setSize(400,500);                                                   //positionné notre fenetre au centre 
        setLocationRelativeTo(null);                                    //terminer le processus lorsque on clique sur la croix rouge 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nouveau_utilisateur=new JButton("nouveau_utilisateur");
        identification =new JButton("identification");
        identification.addActionListener(this);
        nouveau_utilisateur.addActionListener(this);

        pan.add(identification);
        pan.add(nouveau_utilisateur);

        add(pan);   

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //Some code
    }

}