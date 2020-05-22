String info;
        PainandFeverReliever.setEditable(true);       
 info = "Item : " + PainandFeverReliever.getItemAt(0) + "\n";
 info  += "Count; " + PainandFeverReliever.getItemCount() + "\n";
 info += "Selected ID: " + PainandFeverReliever.getSelectedIndex() + "\n";
 info += "Selected : " + PainandFeverReliever.getSelectedItem() + "\n";
 info += "Combo Box Editable: " + PainandFeverReliever.isEditable() + "\n";
JOptionPane.showMessageDialog(ItemCheck.this, info, "Information", JOptionPane.INFORMATION_MESSAGE);
info = "";