public void actionPerformed(ActionEvent arg0)
{
    String s = Textbox.getText();
    int res = Integer.parseInt(s);
    String result = String.valueOf((res-32)*(5)/(9));
    label.setText(result);
}