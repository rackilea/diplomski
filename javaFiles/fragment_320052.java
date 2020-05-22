public class CalculateButtonHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){
        calculate();
    }
}

private void calculate() {
    double a,b,c,d,f,g,h;

    try {
        a=Double.parseDouble(powTF.getText());
        b=Double.parseDouble(hoursTF.getText());
    } catch (NumberFormatException nfe) {
        return;
    }

    c=(a*b)/1000;
    d=c*30;
    f=d*12;

    dayTF.setText(""+c);
    monthTF.setText(""+d);
    yearTF.setText(""+f);

}