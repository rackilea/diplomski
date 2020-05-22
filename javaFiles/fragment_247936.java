public class Listener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        JButton btn = (JButton)source;
        btn.setEnabled(false);
        btn.setFont(new Font("Courier New", Font.BOLD, 56));
        counter++;
        if(counter % 2 == 0 && counter < 10){
            btn.setText("O");
            gameText.setText("X's Turn!");                    
        } else {                       
            btn.setText("X");
            gameText.setText("O's Turn!");
        }           
        gameOver();
    }
}