{
    int num1,num2,num3,sum;
    num1=Integer.parseInt(PB_cash.getText().trim());
    num2=Integer.parseInt(DC_cash.getText().trim());
    num3=Integer.parseInt(BD_cash.getText().trim());
    sum=num1+num2-num3;
    HB_cash.setText(" " + String.valueOf(sum)); //why you want the space is beyond me :)
}