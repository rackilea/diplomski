import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author rafaelcarlos
 */
public class FrameTemp extends JFrame implements ActionListener {

private String title = "Adicionar novo";
private ArrayList<Academico> academicos;
private static Academico academico;
private JTextField tfMatricula, tfNome, tfCurso, tfPeriodo;
private JButton btConfirmar;

public FrameTemp() {
    this.setTitle(title);
    Container c = getContentPane();

    c.setLayout(new BorderLayout());

    Container c2 = new JPanel();
    c2.setLayout(new GridLayout(1, 4));
    academico = new Academico();
    academicos = new ArrayList<Academico>();

    this.btConfirmar = new JButton("Confirmar");
    this.tfMatricula = new JTextField();
    this.tfMatricula.setToolTipText("Insira sua matrícula aqui");
    PromptSupport.setPrompt("Matrícula", tfMatricula);
    PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, tfMatricula);
    PromptSupport.setFontStyle(Font.BOLD, tfMatricula);

    this.tfNome = new JTextField();
    this.tfNome.setToolTipText("Insira seu nome aqui");
    PromptSupport.setPrompt("Nome", tfNome);
    PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, tfNome);
    PromptSupport.setFontStyle(Font.BOLD, tfNome);

    this.tfCurso = new JTextField();
    this.tfCurso.setToolTipText("Insira seu curso aqui");
    PromptSupport.setPrompt("Curso", tfCurso);
    PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, tfCurso);
    PromptSupport.setFontStyle(Font.BOLD, tfCurso);

    this.tfPeriodo = new JTextField();
    this.tfPeriodo.setToolTipText("Insira seu período aqui");
    PromptSupport.setPrompt("Período", tfPeriodo);
    PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, tfPeriodo);
    PromptSupport.setFontStyle(Font.BOLD, tfPeriodo);

    btConfirmar.addActionListener(this);
    c2.add(tfMatricula);
    c2.add(tfNome);
    c2.add(tfCurso);
    c2.add(tfPeriodo);

    c.add(btConfirmar);

    c.add(BorderLayout.NORTH, c2);
    c.add(BorderLayout.SOUTH, btConfirmar);

    this.setVisible(true);
    this.setSize(500, 300);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}

//Metodo que você vai usar para recuperar os dados na outra classe
public static Academico getAcademico() {
    return FrameTemp.academico;
}

@Override
public void actionPerformed(ActionEvent e) {

    this.academico.setMatricula(tfMatricula.getText());
    this.academico.setNome(tfNome.getText());
    this.academico.setCurso(tfCurso.getText());
    this.academico.setPeriodo(Integer.parseInt(tfPeriodo.getText()));
    ;
    Frame.addAcademico(academico);
    this.dispose();
}

}