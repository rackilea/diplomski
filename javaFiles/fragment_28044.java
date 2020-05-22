while(true) { // instead of while(true) you can also write other condition
 String a = JOptionPane.showInputDialog(null,"Please pick something for me to do  master:\nMynumber,Read2me, Conversions");
 if (a.equals("Mynumber")) {
    MyNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter your number: "));
    String b = JOptionPane.showInputDialog(null,"Was Your number "+MyNumber+"\n Y/N");
    if (b.equals("y")) {
        JOptionPane.showMessageDialog(null,"Good...good, now lets play with\n your number");
    }
    else if(b.equals("N")) {
        JOptionPane.showMessageDialog(null,"returning");
    }
 }
}