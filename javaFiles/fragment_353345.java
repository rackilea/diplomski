import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Frame extends JFrame implements ActionListener {

private static Academico novoAcademico;
private static FrameTemp frameTemporario;
private JTable tabela;
private static DefaultTableModel modelo;
private ArrayList<Academico> academicos;
private JButton btAdd, btAtualizar, btDelete;
private JPanel painel, painelGrid;
private BorderLayout borderLayout;
private GridLayout gridLayout;

public Frame(Academico academico) {
    this.setTitle("Acadêmicos Cadastrados");
    this.painel = new JPanel();
    this.painelGrid = new JPanel();

    borderLayout = new BorderLayout();
    gridLayout = new GridLayout(1, 3);
    setContentPane(painel);
    this.setLayout(borderLayout);

    painel.add(painelGrid);
    painelGrid.setLayout(gridLayout);

    this.modelo = new DefaultTableModel();
    this.tabela = new JTable(modelo);
    this.btAdd = new JButton("Insert");
    this.btAdd.setFont(new Font("Verdana", Font.PLAIN, 20));
    this.btAdd.setBackground(Color.BLACK);
    this.btAdd.setForeground(Color.WHITE);
    this.btAtualizar = new JButton("Update");
    this.btAtualizar.setFont(new Font("Verdana", Font.PLAIN, 20));
    this.btAtualizar.setBackground(Color.BLACK);
    this.btAtualizar.setForeground(Color.WHITE);
    this.btDelete = new JButton("Delete");
    this.btDelete.setFont(new Font("Verdana", Font.PLAIN, 20));
    this.btDelete.setBackground(Color.BLACK);
    this.btDelete.setForeground(Color.WHITE);

    this.modelo.addColumn("Matrícula");
    this.modelo.addColumn("Nome");
    this.modelo.addColumn("Curso");
    this.modelo.addColumn("Período");

    this.tabela.getColumnModel().getColumn(0).setPreferredWidth(20);
    this.tabela.getColumnModel().getColumn(1).setPreferredWidth(30);
    this.tabela.getColumnModel().getColumn(2).setPreferredWidth(50);
    this.tabela.getColumnModel().getColumn(3).setPreferredWidth(20);

    this.academicos = new ArrayList<>();

    this.academicos.add(new Academico("123", "Fredson", "Sistemas de Informação", 3));
    this.academicos.add(new Academico("234", "Vieira", "Ciência da Computação", 5));
    this.academicos.add(new Academico("345", "Costa", "Engenharia da Computação", 7));

    for (Academico a : this.academicos) {
        this.modelo.addRow(new Object[]{a.getMatricula(), a.getNome(), a.getCurso(), a.getPeriodo()});
    }

    this.painel.add(BorderLayout.NORTH, new JScrollPane(this.tabela));
    this.painel.add(BorderLayout.SOUTH, painelGrid);
    this.painelGrid.add(btAdd);
    this.painelGrid.add(btAtualizar);
    this.painelGrid.add(btDelete);

    this.btDelete.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            int dialog = JOptionPane.YES_NO_OPTION;

            int selRow = tabela.getSelectedRow();
            if (selRow != -1) {
                int resultado = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir essa linha?", "Confirmação", dialog);

                if (resultado == 0) {
                    modelo.removeRow(selRow);
                    JOptionPane.showMessageDialog(null, "Registro excluído com sucesso!" + "\nTotal de registros existentes: " + modelo.getRowCount());
                }

            }
        }
    }
    );

    this.btAdd.addActionListener(this);

    this.pack();

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setVisible(true);
}

public static void main(String[] args) {
    new Frame(novoAcademico);
}

@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btAdd) {

        frameTemporario = new FrameTemp();
        frameTemporario.setVisible(true);

    }
}

public static void addAcademico(Academico academico) {
    academico = frameTemporario.getAcademico();

    ArrayList<Academico> lista = new ArrayList<>();

    lista.add(new Academico(academico.getMatricula(), academico.getNome(), academico.getCurso(), academico.getPeriodo()));

    for (Academico a : lista) {
        System.out.println("Lista: " + lista.size());
        modelo.addRow(new Object[]{a.getMatricula(), a.getNome(), a.getCurso(), a.getPeriodo()});
        System.out.println(a.getMatricula() + "\n" + a.getNome() + "\n" + a.getCurso() + "\n" + a.getPeriodo());
    }

}

}