import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.MaskFormatter;

public class Testing {

    public static void main(String[] args) {
        new Testing();
    }

    public Testing() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        ex.printStackTrace();
                    }

                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setContentPane(new Background());
                    JPanel painelCadastro = painelCadastro();
                    painelCadastro.setOpaque(false);
                    frame.add(painelCadastro);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public JPanel painelCadastro() {
        JPanel telaAtual = new JPanel();
        JTextField nome, telefone, aniversario, email;
        String definicao;
        JLabel lugarnome, lugartelefone, lugaraniversario, lugaremail;
        JTextArea endereço;

        telaAtual.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        //c.anchor = GridBagConstraints.WEST;
        //c.ipadx = 2;
        //c.ipady = 3;
        //c.gridheight = GridBagConstraints.REMAINDER;  
        //c.gridwidth = GridBagConstraints.REMAINDER;  

        lugarnome = new JLabel("Nome");
        c.weightx = 1; // percentual de tamanho em relação aos demais
        c.gridwidth = 1; //tamanho do compontente em celulas HORIZONTAL
        c.gridheight = 1; //tamanho do compontente em celulas VERTICAL
        c.gridx = 0; //localização da celula na coluna
        c.gridy = 0; //localização da celula na linha
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 0, 0);
        telaAtual.add(lugarnome, c);

        nome = new JTextField("Digite seu nome aqui");
        definicao = "nome";
        c.weightx = 1; // percentual de tamanho em relação aos demais
        c.gridwidth = 7; //tamanho do compontente em celulas HORIZONTAL
        c.gridx = 1; //localização da celula na linha
        c.gridy = 0; //localização da celula na coluna
        //c.fill = GridBagConstraints.HORIZONTAL;
//      limpaCaixaTexto(nome, definicao);
        telaAtual.add(nome, c);

        lugartelefone = new JLabel("Telefone");
        c.weightx = 1; // percentual de tamanho em relação aos demais
        c.gridx = 0; //localização da celula na linha
        c.gridy = 1; //localização da celula na coluna
        c.fill = GridBagConstraints.NONE;
        telaAtual.add(lugartelefone, c);

        telefone = new JTextField("Digite seu telefone aqui");
        definicao = "telefone";
        c.weightx = 2; // percentual de tamanho em relação aos demais
        c.gridx = 1; //localização da celula na linha
        c.gridy = 1; //localização da celula na coluna
        c.fill = GridBagConstraints.HORIZONTAL;
//      limpaCaixaTexto(telefone, definicao);
        telaAtual.add(telefone, c);

        lugaremail = new JLabel("Email");
        c.weightx = 1; // percentual de tamanho em relação aos demais
        c.gridx = 0; //localização da celula na linha
        c.gridy = 2; //localização da celula na coluna
        c.fill = GridBagConstraints.NONE;
        telaAtual.add(lugaremail, c);

        email = new JTextField("Digite seu e-mail aqui");
        definicao = "e-mail";
        c.weightx = 2; // percentual de tamanho em relação aos demais
        c.gridx = 1; //localização da celula na linha
        c.gridy = 2; //localização da celula na coluna
        c.fill = GridBagConstraints.HORIZONTAL;
//      limpaCaixaTexto(email, definicao);
        telaAtual.add(email, c);

        //--------- INICIO CAMPO DATA -------------
        lugaraniversario = new JLabel("Data de Nascimento");
        c.weightx = 1; // percentual de tamanho em relação aos demais
        c.gridx = 0; //localização da celula na linha
        c.gridy = 3; //localização da celula na coluna
        c.fill = GridBagConstraints.NONE;
        telaAtual.add(lugaraniversario, c);

        //JFormattedTextField dataAniversario = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.MEDIUM));
        //GregorianCalendar data = new GregorianCalendar();
        //dataAniversario.setText(data.get(Calendar.DAY_OF_MONTH) + "/" + (data.get(Calendar.MONTH) + 1) + "/" + (data.get(Calendar.YEAR)));
        DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        JFormattedTextField dataAniversario = new JFormattedTextField(df);
        try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.install(dataAniversario);

        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        definicao = "aniversario";
        c.weightx = 2; // percentual de tamanho em relação aos demais
        c.gridx = 1; //localização da celula na linha
        c.gridy = 3; //localização da celula na coluna
        c.fill = GridBagConstraints.HORIZONTAL;
//      limpaCaixaTexto(dataAniversario, definicao);
        telaAtual.add(dataAniversario, c);

        //--------- FIM CAMPO DATA -------------
        return telaAtual;
    }

    public class Background extends JPanel {

        private BufferedImage backgroundImage;

        public Background() throws IOException {
            this.backgroundImage = ImageIO.read(new File("..."));
            setLayout(new BorderLayout());
        }

        @Override
        public Dimension getPreferredSize() {
            return backgroundImage == null ? new Dimension(200, 200) : new Dimension(backgroundImage.getWidth(), backgroundImage.getHeight());
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, this);
        }
    }
}