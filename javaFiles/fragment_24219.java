import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;


public class Demo {

    private void createAndShowGUI() {

        String[] header = {"id_aluno", "nome_aluno", "matricula", "telefone", "email", "sexo"};
        ArrayList<Object[]> data = new ArrayList<>();
        data.add(new Object[] {1, "Fernando", "1234567890", "1234-567890", "email@example.com", "M"});

        TableModel model = new TabelaAlunos(data, header);
        JTable table = new JTable(model);

        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Demo().createAndShowGUI();
            }
        });
    }

    public class TabelaAlunos extends AbstractTableModel {

        private ArrayList linhas;
        private String[] colunas;

        public TabelaAlunos(ArrayList lin, String[] col) {
            setColunas(col);
            setLinhas(lin);
        }

        public ArrayList getLinhas() {
            return linhas;
        }

        public void setLinhas(ArrayList dados) {
            linhas = dados;
        }

        public String[] getColunas() {
            return colunas;
        }

        public void setColunas(String[] nomes) {
            colunas = nomes;
        }

        @Override
        public int getColumnCount() {
            return colunas.length;
        }

        @Override
        public int getRowCount() {

            return linhas.size();
        }
        @Override
        public String getColumnName(int columnIndex) {
            return colunas[columnIndex];

        }

        @Override
        public Object getValueAt(int numLin, int columnIndex) {
            Object[] linha = (Object[]) getLinhas().get(numLin);
            return linha[columnIndex];
        }
    }
}