public class ApplianceChangeListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {
        int item = appCB.getSelectedIndex();

        if (item == 0) powTF.setText("");
        else powTF.setText("" + appPower[item]);

        calculate();
    }
}