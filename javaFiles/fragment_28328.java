import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.border.Border;

public class QueryBuilderUI extends javax.swing.JFrame {

   protected static final int PREF_W = 400;

   protected static final int PREF_H = 200;

   QueryBuilderMethods objQBM = new QueryBuilderMethods();

   DefaultComboBoxModel<String> repoModel = new DefaultComboBoxModel<String>();

   public QueryBuilderUI() {
      getRepositoryListing();
      initComponents();
   }

   private void getRepositoryListing() {
      repoModel = new QueryBuilderMethods().getAllRepositoryName();
   }

   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">
   private void initComponents() {

      jLabel1 = new javax.swing.JLabel();
      jComboBox1 = new javax.swing.JComboBox();
      jLabel2 = new javax.swing.JLabel();
      jComboBox2 = new javax.swing.JComboBox();
      jLabel3 = new javax.swing.JLabel();
      jPanel1 = new javax.swing.JPanel() {
         @Override 
         // !! so the JPanel has some size. This is a shameless kludge *****
         public Dimension getPreferredSize() {
            if (isPreferredSizeSet()) {
               return super.getPreferredSize();
            }
            return new Dimension(PREF_W, PREF_H);
         }
      };
      jTextField1 = new javax.swing.JTextField();
      jLabel4 = new javax.swing.JLabel();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jLabel1.setText("Choose Repository");

      jComboBox1.setModel(repoModel);
      jComboBox1.addItemListener(new java.awt.event.ItemListener() {
         public void itemStateChanged(java.awt.event.ItemEvent evt) {
            jComboBox1ItemStateChanged(evt);
         }
      });

      jLabel2.setText("Choose Table");

      // jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
      // "Item 1", "Item 2", "Item 3", "Item 4" }));

      jComboBox2.addItemListener(new java.awt.event.ItemListener() {
         public void itemStateChanged(java.awt.event.ItemEvent evt) {
            jComboBox2ItemStateChanged(evt);
         }
      });

      jLabel3.setText("Choose Columns");

      // *************** Note Changes Below ****************

      // !! javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
      // !! jPanel1);
      // !! jPanel1.setLayout(jPanel1Layout);

      // !! jPanel1 now uses JPanel's default FlowLayout

      Border border = BorderFactory.createTitledBorder("Select Columns");
      jPanel1.setBorder(border);

      jTextField1.setText("jTextField1");

      jLabel4.setText("Generated Query");

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
            getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                  layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(
                              layout.createParallelGroup(
                                    javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(
                                          layout.createSequentialGroup()
                                                .addGroup(
                                                      layout.createParallelGroup(
                                                            javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(
                                                                  jLabel1)
                                                            .addComponent(
                                                                  jLabel2))
                                                .addGap(57, 57, 57)
                                                .addGroup(
                                                      layout.createParallelGroup(
                                                            javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(
                                                                  jComboBox1,
                                                                  javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                  106,
                                                                  javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(
                                                                  jComboBox2,
                                                                  javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                  106,
                                                                  javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(
                                          jPanel1,
                                          javax.swing.GroupLayout.PREFERRED_SIZE,
                                          javax.swing.GroupLayout.DEFAULT_SIZE,
                                          javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(
                                          jTextField1,
                                          javax.swing.GroupLayout.PREFERRED_SIZE,
                                          412,
                                          javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(65, Short.MAX_VALUE)));
      layout.setVerticalGroup(layout.createParallelGroup(
            javax.swing.GroupLayout.Alignment.LEADING).addGroup(
            layout.createSequentialGroup()
                  .addGap(18, 18, 18)
                  .addGroup(
                        layout.createParallelGroup(
                              javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel1)
                              .addComponent(jComboBox1,
                                    javax.swing.GroupLayout.PREFERRED_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(18, 18, 18)
                  .addGroup(
                        layout.createParallelGroup(
                              javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel2)
                              .addComponent(jComboBox2,
                                    javax.swing.GroupLayout.PREFERRED_SIZE,
                                    javax.swing.GroupLayout.DEFAULT_SIZE,
                                    javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(18, 18, 18)
                  .addComponent(jLabel3)
                  .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jPanel1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(44, 44, 44)
                  .addComponent(jLabel4)
                  .addGap(18, 18, 18)
                  .addComponent(jTextField1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addContainerGap(92, Short.MAX_VALUE)));

      pack();
   }// </editor-fold>

   private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {
      // TODO add your handling code here:
      if (evt.getStateChange() == ItemEvent.SELECTED) {
         Object item = evt.getItem();
         DefaultComboBoxModel<String> modelTable = objQBM
               .getAllTablesForRepo(item.toString());
         jComboBox2.setModel(modelTable);
      }
   }

   private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {
      // TODO add your handling code here:
      if (evt.getStateChange() == ItemEvent.SELECTED) {
         Object item = evt.getItem();
         String RepoName = jComboBox1.getSelectedItem().toString();
         List<String> columnNames = objQBM.getAllColumnsForTable(item
               .toString());
         addCheckBox(columnNames);
      }
   }

   private void addCheckBox(List<String> columnNames) {
      int numberCheckBox = columnNames.size();
      JCheckBox[] checkBoxList = new JCheckBox[numberCheckBox];

      System.out.println("numberCheckBox = " + numberCheckBox);
      for (int i = 0; i < numberCheckBox; i++) {
         checkBoxList[i] = new JCheckBox("hi" + i);
         jPanel1.add(checkBoxList[i]);

      }

      jPanel1.revalidate();
      jPanel1.repaint();
      System.out.println("check boxes added");
   }

   public static void main(String args[]) {

      // java.awt.EventQueue.invokeLater(new Runnable() {
      // public void run() {
      new QueryBuilderUI().setVisible(true);

      // }
      // });
   }

   // Variables declaration - do not modify
   private javax.swing.JComboBox jComboBox1;
   private javax.swing.JComboBox jComboBox2;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JTextField jTextField1;
   // End of variables declaration
}