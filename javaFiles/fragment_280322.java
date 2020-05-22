import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MainFrame extends javax.swing.JFrame {
    private JButton button1;
    private JTextField val1;
    private JTextField val2;
    private JScrollPane scrollpanel;
    private JButton button_replace;
    private JTable table1;

    public static void main(String[] args) {
        MainFrame frame=new MainFrame();
        frame.show();
    }

    public MainFrame() {
        super();
        //creating components   
        FlowLayout thisLayout = new FlowLayout();
        getContentPane().setLayout(thisLayout);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        button1 = new JButton();
        getContentPane().add(button1);
        button1.setText("add");
        button1.setPreferredSize(new java.awt.Dimension(81, 23));
        val1 = new JTextField();
        getContentPane().add(val1);
        val1.setPreferredSize(new java.awt.Dimension(51, 23));
        val2 = new JTextField();
        getContentPane().add(val2);
        val2.setPreferredSize(new java.awt.Dimension(53, 23));
        pack();
        setSize(400, 300);
        //add the table now
        scrollpanel = new JScrollPane();        
        scrollpanel.setPreferredSize(new java.awt.Dimension(339, 169));
        getContentPane().add(scrollpanel);
        table1 = new JTable();
        scrollpanel.setViewportView(table1);
        table1.setModel(new jtableExemple.TableModel());
        TableModel table_model=(TableModel) table1.getModel();
        table_model.add_row(new String[]{"row1","row1"});
        table_model.add_row(new String[]{"row2","row2"});
        table_model.add_row(new String[]{"row3","row3"});
        button_replace = new JButton();
        getContentPane().add(button_replace);
        button_replace.setText("Replace all list");


        //add action to button 
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
            TableModel table_model=(TableModel) table1.getModel();
            table_model.add_row(new String[]{val1.getText(),val2.getText()});
            //this line to the change in the UI 
            table1.setRowHeight(table1.getRowHeight());
            }
        });

        button_replace.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                //create a random list
                TableModel table_model=(TableModel) table1.getModel();
                Vector<String[]>new_list=new Vector<String[]>();
                for(int i=0;i<100;i++)
                    new_list.add(new String[]{"new row "+i,"new row "+i});
                table_model.setList(new_list);
                //this line to the change in the UI 
                table1.setRowHeight(table1.getRowHeight());             
            }
        });

}


}