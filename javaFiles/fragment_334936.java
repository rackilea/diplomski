Date rowDate= dateFormat.parse(jTable2.getValueAt(k, 6).toString());

if (c7.compareTo(rowDate)==0) { //the two dates are equal
                JOptionPane.showMessageDialog(null, "Record exist");
                model.removeRow(jTable2.getRowCount()-1);
                return;
    }