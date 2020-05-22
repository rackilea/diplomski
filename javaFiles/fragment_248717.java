class MainPanel extends JPanel //in your case, you extends to JFrame
{
    private JButton btn;

    public MainPanel(){
        //other initializations
        btn.add(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //invoke your conversion method here..
                //e.g: 
                //txtResult.setText(convert(txtInput.getText()));
            }
        });
    }
}