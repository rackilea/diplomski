import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame extends JFrame {

    private JPanel panel, mensagem, operacao;
    private JTextArea sucesso;
    private JLabel numero1, numero2;
    private JTextField resposta;
    private Color pink = new Color(255, 213, 224);
    //more vars

    public Frame() {
        super("Jogo de Multiplicar!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(300, 200);
        getContentPane().setBackground(pink);
        panel = new TransperantPanel();
        mensagem = new TransperantPanel();
        operacao = new TransperantPanel();
        mensagem.setLayout(new FlowLayout(FlowLayout.CENTER));
        operacao.setLayout(new FlowLayout(FlowLayout.CENTER));

        sucesso = new JTextArea();
        sucesso.setEditable(false);

        Random randomGen = new Random();
        int random1 =0 , random2 = 0;   
        while (random1 == 0)
            random1 = randomGen.nextInt(10);
        while (random2 == 0)
            random2 = randomGen.nextInt(10);
        int res = random1 * random2;

        numero1 = new JLabel();
        numero2 = new JLabel();
        numero1.setText(random1 + " *");
        numero2.setText(random2 + " =");    


        resposta = new JTextField(2);
        resposta.setOpaque(false);
        resposta.addActionListener(new MinhaAcao());
        numero1.setFont(minhaFont);
        numero2.setFont(minhaFont);
        resposta.setFont(minhaFont);

        operacao.add(numero1);
        operacao.add(numero2);
        operacao.add(resposta);

        mensagem.add(sucesso);

        add(operacao);
        add(mensagem, BorderLayout.SOUTH);

    }

    public static void main(String[] args){
        Frame f = new Frame();
        f.setVisible(true);
    }

    class TransperantPanel extends JPanel {

        public TransperantPanel() {
            setOpaque(false);
        }

    }
}