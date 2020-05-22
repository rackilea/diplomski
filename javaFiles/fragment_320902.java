private class ButtonHandler implements ActionListener{
    public void actionPerformed(ActionEvent handler){
        times++;
        clicksCounter.setText("Clicks:"+times);
    }
}