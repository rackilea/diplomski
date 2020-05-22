import javax.swing.ImageIcon;

private void profile_tableMouseClicked(java.awt.event.MouseEvent evt)
{
   DefaultTableModel model = (DefaultTableModel) profile_table.getModel();
   dr_profile_image.setIcon(
      new ImageIcon(model.getValueAt(profile_table.getSelectedRow(),9).toString());
}