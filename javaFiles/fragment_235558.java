msp.addMyPortListener(new SerialPortListener() {
    @Override
    public void stringReveivedFromSerialPort(String s) {
        JOptionPane.showMessageDialog(MyJFrame.this, s);
    }
});