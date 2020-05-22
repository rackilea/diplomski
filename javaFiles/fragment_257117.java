class ToggleButton extends JButton{

    private Color onColor;
    private Color offColor;
    private boolean isOff;

    public ToggleButton(String text){
        super(text);
        init();
        updateButtonColor();
    }

    public void toggle(){
        isOff ^= true;
        updateButtonColor();            
    }

    private void init(){
        onColor = Color.YELLOW;
        offColor = Color.RED;
        isOff = true;
        setFont(new Font("Arial", Font.PLAIN, 40));     
    }

    private void updateButtonColor(){
        if(isOff){
            setBackground(offColor);
            setText("OFF");
        }           
        else{
            setBackground(onColor); 
            setText("ON");
        }           
    }   
}