String num1 = mEtfirst.getText().toString(); 
char[] temp = num1.toCharArray();
int i=0;
num1="";

while(Character.isDigit(temp[i]))
     num1=num1+Character.toString(temp[i++]);