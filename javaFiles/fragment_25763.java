import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Template_StackOverflowExample extends JPanel{

    //changed type to DialogTemplate so you can use getData()
    //Alternatively you can keep the type as JPanle and cast:
    // ((DialogTemplate)diagPanel1).getData()
    private DialogTemplate diagPanel1 = new DialogTemplate();
    private DialogTemplate diagPanel2 = new DialogTemplate();

    Object[] columnIdentifiers = {
            "id",
            "imei",
    };

    Object[][] data = {
            {"1", "123"},
            {"2", "123"},
            {"3", "123"}
    };

    //changed type to JDialog subclass
    private Dialog addDialog;
    private Dialog editDialog;

    private static DefaultTableModel model;
    private JTable table;

    public Template_StackOverflowExample(){
        setLayout(new BorderLayout());
        JPanel pane = new JPanel(new BorderLayout());

        JButton addRow = new JButton("Add Row");
        addRow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addDialog = openDialog("Add Row");
                Object[] getData = addDialog.getData();
                printRow(getData);
            }
        });
        JButton editRow = new JButton("Edit Row");
        editRow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                editDialog = openDialog("Edit Row");
                Object[] getData = editDialog.getData();
                printRow(getData);

            }
        });

        JPanel buttonPane = new JPanel(new GridLayout(0, 1));
        TitledBorder buttonBorder = new TitledBorder("Buttons");
        buttonPane.setBorder(buttonBorder);

        buttonPane.add(addRow);
        buttonPane.add(editRow);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(columnIdentifiers);
        JTable table = new JTable(model);

        for(int i = 0; i < data.length; i++){
            model.insertRow(i, data[i]);
        }

        JScrollPane scrollPane = new JScrollPane(table);

        pane.add(buttonPane, BorderLayout.LINE_END);
        pane.add(scrollPane, BorderLayout.CENTER);

        add(pane, BorderLayout.CENTER);
    }

    public Dialog openDialog(String name){

        Window win = SwingUtilities.getWindowAncestor(this);
        return new Dialog(win, new DialogTemplate(), name);
    }

    public void printRow(Object[] data){

        //add null protection
        if(data == null) {
            return;
        }
        int length = data.length;
        String s = "[";
        for(int i = 0; i < length; i++){
            if(i == (length-1)){
                s += data[i].toString() + "]";
            } else {
                s += data[i].toString() + ", ";
            }
        }
        System.out.println(s);
    }

    public static void createAndShowGUI(){
        JFrame frame = new JFrame("MCVE");
        Template_StackOverflowExample mainPanel = new     Template_StackOverflowExample();
        frame.add(mainPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

//subclassed JDialog to add get data functionality
class Dialog extends JDialog {

    DialogTemplate diagPanel;

    Dialog(Window win, DialogTemplate diagPanel, String name) {

        super(win, name,  ModalityType.APPLICATION_MODAL);
        this.diagPanel = diagPanel;
        getContentPane().add(diagPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    Object[] getData(){
        return diagPanel.getData();
    }
}


//changed name to start with capital letter
class DialogTemplate extends JPanel{

    private JComponent[] content;
    private String[] labelHeaders = {
            "ID:",
            "IMEI:",
    };

    private Object[] lastData;

    public DialogTemplate(){
        JPanel diagTemplate = new JPanel();
        diagTemplate.setLayout(new BorderLayout());
        JPanel rowContent = new JPanel(new GridLayout(0, 2));

        JLabel idLabel = null;
        JLabel imeiLabel = null;

        JLabel[] labels = {
                idLabel,
                imeiLabel,
        };

        JTextField idTextField = new JTextField(20);
        JTextField imeiTextField = new JTextField(20);

        content = new JComponent[] {
                idTextField,
                imeiTextField,
        };

        for(int i = 0; i < labels.length; i++){
            labels[i] = new JLabel(labelHeaders[i]);
            rowContent.add(labels[i]);
            rowContent.add(content[i]);
            labels[i].setLabelFor(content[i]);
        }

        JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
                closeWindow();
            }
        });
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                closeWindow();
            }
        });

        JPanel buttonPane = new JPanel(new GridLayout(0, 1, 5, 5));
        buttonPane.add(save);
        buttonPane.add(cancel);

        buttonPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        diagTemplate.add(buttonPane, BorderLayout.PAGE_END);
        diagTemplate.add(rowContent, BorderLayout.CENTER);

        add(diagTemplate);
    }

    public void saveData(){
        lastData = new Object[content.length];

        for(int i = 0; i < lastData.length; i++){
            if(content[i] instanceof JTextField){
                JTextField temp = (JTextField) content[i];
                lastData[i] = temp.getText();
            }
        }
    }

    public Object[] getData(){
        return lastData;
    }

    public void closeWindow(){
        Window win = SwingUtilities.getWindowAncestor(this);
        if(win != null) {
            win.dispose();
        }
    }
}