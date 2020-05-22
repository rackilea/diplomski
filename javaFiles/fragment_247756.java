import java.awt.EventQueue;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class MySql extends JFrame{
    JTable table = new JTable();
    DefaultTableModel model = new DefaultTableModel(new Object[][]{},new String[]{"First column","Second column"});

    public MySql(){
        table.setModel(model);
        add(new JScrollPane(table));

        //Populate table
        BazaDana bd = new BazaDana();
        List<Value> values = bd.selectAll();
        for(Value v : values){
            model.addRow(new Object[]{v.getFirstValue(),v.getSecondValue()});
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run() {
                MySql ms = new MySql();
                ms.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ms.pack();
                ms.setVisible(true);
            }});
    }
}