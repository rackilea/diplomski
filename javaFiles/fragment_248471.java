public class SO {
public static void main(String args[]) {
JFrame frame = new JFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

Vector<String> rowOne = new Vector<String>();
rowOne.addElement("Bob");
rowOne.addElement("dave");
rowOne.addElement("Rowan");

Vector<String> rowTwo = new Vector<String>();
rowTwo.addElement("Jane");
rowTwo.addElement("Florence");
rowTwo.addElement("Heather");

Vector<String> rowThree = new Vector<String>();
rowThree.add("Star Wars");
rowThree.add("Darth Vader");
rowThree.add("Great White Shark");


Vector<Vector<String>> rowData = new Vector<Vector<String>>();
rowData.addElement(rowOne);
rowData.addElement(rowTwo);
rowData.addElement(rowThree);


Vector<String> columnNames = new Vector<String>();
columnNames.addElement("Column One");
columnNames.addElement("Column Two");
columnNames.addElement("Column Three");  
table = new JTable(rowData, columnNames);


//This is where the extra class comes in
Action action = new AbstractAction()
{
    public void actionPerformed(ActionEvent e)
    {
        TableCellListener tcl = (TableCellListener)e.getSource();
        if(tcl.getNewValue() == null || tcl.getNewValue().toString().trim().equals("")){
            table.getModel().setValueAt(tcl.getOldValue(), tcl.getRow(), tcl.getColumn());
        }
        System.out.println("Row   : " + tcl.getRow());
        System.out.println("Column: " + tcl.getColumn());
        System.out.println("Old   : " + tcl.getOldValue());
        System.out.println("New   : " + tcl.getNewValue());
    }
};
new TableCellListener(table, action);

frame.add(table);
JScrollPane scrollPane = new JScrollPane(table);
frame.add(scrollPane, BorderLayout.CENTER);
frame.setSize(700, 240);
frame.setVisible(true);
  }

 private static JTable table;
 }