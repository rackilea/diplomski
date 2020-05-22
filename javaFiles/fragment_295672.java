class ClassName{

    private static ArrayList <Integer> intMarks; 

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {                                       
        int intEnter = Integer.parseInt(this.txtEnter.getText());
        intMarks.add(intEnter);
    }                                      


    public static void main(String args[]) {
        intMarks = new ArrayList<>();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MarksCalculator().setVisible(true);
            }
        });
    }
}