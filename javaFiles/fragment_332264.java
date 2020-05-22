import javax.swing.JOptionPane;

public class example extends javax.swing.JFrame {

String nameStr = ""; //Here I save the name entered.

public example() {
    initComponents();
}

private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {                                      
    nameStr = nameTxt.getText();
    nameTxt.setText("");
}                                     

private void showBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
    JOptionPane.showMessageDialog(null, "You entered this name: " + nameStr);
}                                       

public static void main(String args[]) {

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new example().setVisible(true);
        }
    });
}

@SuppressWarnings("unchecked")
// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
private void initComponents() {

    aboutLbl = new javax.swing.JLabel();
    inputLbl = new javax.swing.JLabel();
    nameTxt = new javax.swing.JTextField();
    okBtn = new javax.swing.JButton();
    showBtn = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    aboutLbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    aboutLbl.setText("Example by José Peña");

    inputLbl.setText("Input your name:");

    okBtn.setText("OK");
    okBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            okBtnActionPerformed(evt);
        }
    });

    showBtn.setText("Show my name entered");
    showBtn.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            showBtnActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(showBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
                .addComponent(aboutLbl)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(inputLbl)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(okBtn))))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(aboutLbl)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(inputLbl)
                .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(okBtn))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(showBtn)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
}// </editor-fold>                        


// Variables declaration - do not modify                     
private javax.swing.JLabel aboutLbl;
private javax.swing.JLabel inputLbl;
private javax.swing.JTextField nameTxt;
private javax.swing.JButton okBtn;
private javax.swing.JButton showBtn;
// End of variables declaration                   
}