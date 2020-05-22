int b = 0; // make b an instance variable

public void actionPerformed(ActionEvent ae)
{
    int a = ran.nextInt(6) +1;//random number
    num[b].setIcon(null); //remove the icon from from previously set label

    b=a;  //since b already has some value, b+=a might create unexpected result, hence just assigned a  
    if(b>=100)
    {
       b=99;
       num[b].setIcon(icon);
    }
    else
    {                
       num[b].setIcon(icon);
    }
}