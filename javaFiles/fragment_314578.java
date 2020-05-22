public class checkIt2 implements ActionListener { 

        @Override
        public void actionPerformed(ActionEvent e) {
            javax.swing.JOptionPane.showMessageDialog(null, "selected: " +
                    ((JCheckBox)e.getSource()).isSelected());
        }

    }