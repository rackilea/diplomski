import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Abc extends JFrame{
    // PUBLIC VARS
    // VARIAVEIS
    public int numeroButoes = 1;
    // CONSTRUCTOR
    public Abc(){
        super("Loop Buttons");
        setLayout(null);
        // BUTOES ADD & REMOVE
        JButton mais = new JButton("Adiciona");
        mais.addActionListener(new handlerBotaoAdd());
        //JButton menos = new JButton("Remove");
        mais.addActionListener(new handlerBotaoAdd());
        mais.setBounds(50, 0, 100, 40);
        add(mais);


    }

    // Method for button creating
    private void generateButtons(){
        for (int x = 0; x < numeroButoes; x++ ){
            JButton teste = new JButton("Botão " + x);
            teste.setActionCommand("Botão " +x);
            teste.addActionListener(new handlerBotoesLoop(teste.getActionCommand()));
            teste.setBounds(450, (x == 0 ? 0: x+(40*x)), 100, 40);
            add(teste);
        }
    }

    private class handlerBotoesLoop implements ActionListener{
        String texto;
        public handlerBotoesLoop(String x){
            x = texto;
        }
        @Override
        public void actionPerformed(ActionEvent event){
            JOptionPane.showMessageDialog(null, String.format("%s", event.getActionCommand()));
        }
    }
    private class handlerBotaoAdd implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            numeroButoes++;
            generateButtons();
        }
    }
}