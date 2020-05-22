btnCalculate.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent arg0) {
        int answer;
        answer = hour * ig * 6000;
        JOptionPane.showMessageDialog(null, answer);
    }
});