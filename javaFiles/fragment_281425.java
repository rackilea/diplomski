double a,b,e;
System.out.println("arrears = " + arrears.getText());
System.out.println("pay =" + pay.getText());

a=Double.valueOf(arrears.getText());
b=Double.valueOf(pay.getText());
e=a+b;

System.out.println("a = " + a);
System.out.println("b = " + b);
System.out.println("e = " + e);

arrears.setText(String.valueOf(e));