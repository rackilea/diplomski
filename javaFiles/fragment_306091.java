btnStopstart.addActionListener(new ActionListener(){
    private Chrono1 cn = new Chrono1(chrono); // **** add this 

    public void actionPerformed(ActionEvent e) {
        // Chrono1 cn = new Chrono1(chrono); // **** remove this 
        String texte = btnStopstart.getText();
        if(texte.equals("START")){
            btnStopstart.setText("STOP");
            try {
                cn.Editchrono(texte);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else if(texte.equals("STOP")) {
            btnStopstart.setText("START");
            cn.Editchrono(texte);
        }
    }
});