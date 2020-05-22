JTextArea textArea = new JTextArea();
JScrollPane jp = new JScrollPane(textArea);
jp.setBounds(10, 79, 172, 339);
frame.getContentPane().add(jp);

JButton btnNewButton_1 = new JButton("Coordinate Anomalies");
btnNewButton_1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        textArea.setText("");
        ArrayList<String> anomalies = vessels.coordinateAnomaly(); 

        for(String a : anomalies){
               textArea.append(a + "\n");
            }
    }
});
btnNewButton_1.setBounds(10, 45, 172, 23);
frame.getContentPane().add(btnNewButton_1);