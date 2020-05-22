Float num1 = 0, num2 = 0; 
 try { 
     num1 = Float.parseFloat(e1.getText().toString());
     num2 = Float.parseFloat(e2.getText().toString());
 } catch (NumberFormatException e) { }

 Float firstsum = 0;
 if (num1 != 0) { // divide by zero doesn't need try-catch
     firstsum = num2 / num1;
 }
 Float finalsum = firstsum * 100;
 t1.setText(String.format("%.2f%%", finalsum));