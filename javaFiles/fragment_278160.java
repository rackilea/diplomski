public class ClsCreateTextBoxes extends javax.swing.JFrame{
    private javax.swing.JPanel jpInputPanel = null;
    private javax.swing.JTextField jtfRows = null;
    private javax.swing.JTextField jtfColumns = null;
    private javax.swing.JButton jbCreateMatrix = null;
    private javax.swing.JPanel jpMatrixPanel = null;

    public ClsCreateTextBoxes(){
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.BorderLayout());
        jpInputPanel = new javax.swing.JPanel(new java.awt.FlowLayout());
        jtfRows = new javax.swing.JTextField(10);
        jpInputPanel.add(jtfRows);
        jtfColumns = new javax.swing.JTextField(10);
        jpInputPanel.add(jtfColumns);
        jbCreateMatrix = new javax.swing.JButton("Create");
        jbCreateMatrix.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent ae){
                //  Assuming proper number is given
                jpMatrixPanel.setLayout(new java.awt.GridLayout(Integer.parseInt(jtfRows.getText()), Integer.parseInt(jtfColumns.getText())));
                for(int rowIndex = 0; rowIndex < Integer.parseInt(jtfRows.getText()); rowIndex ++){
                    for(int columnIndex = 0; columnIndex < Integer.parseInt(jtfColumns.getText()); columnIndex ++){
                        jpMatrixPanel.add(new javax.swing.JTextField(10));
                        pack();
                    }
                }
            }
        });
        jpInputPanel.add(jbCreateMatrix);
        getContentPane().add(jpInputPanel, java.awt.BorderLayout.NORTH);
        jpMatrixPanel = new javax.swing.JPanel();
        getContentPane().add(jpMatrixPanel, java.awt.BorderLayout.SOUTH);
        pack();
    }
    public static void main(String[] args){
        ClsCreateTextBoxes createdTextBoxes = new ClsCreateTextBoxes();
        createdTextBoxes.setVisible(true);
    }
}