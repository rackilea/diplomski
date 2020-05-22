if (e.getSource() == leftButton)  {
    ((FlowLayout)buttonPanel.getLayout()).setAlignment(FlowLayout.LEFT); //1
    buttonPanel.revalidate(); //2
}
else if (e.getSource() == colorButton) {
    buttonPanel.setBackground(color.BLUE); 
} 
else {
    ((FlowLayout)buttonPanel.getLayout()).setAlignment(FlowLayout.CENTER);
    buttonPanel.revalidate();
}