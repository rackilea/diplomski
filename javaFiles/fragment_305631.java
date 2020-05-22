public void getVals(int value1, int value2, int value3, int value4){
    d1 = value1;
    d2 = value2;
    d3 = value3;
    d4 = value4;
}


try {
    int chk = Integer.parseInt(i1.getText());
    int chk2 = Integer.parseInt(i2.getText());
    int chk3 = Integer.parseInt(i3.getText());
    int chk4 = Integer.parseInt(i4.getText());
    System.out.println("Sucessful");

    Main Obj=new Main();
    Obj.getVals(chk, chk2, chk3, chk4);
    Obj.calculate();
} catch (Exception execpt) {
    JOptionPane.showMessageDialog(null, "Warning", "Please Enter valid String", JOptionPane.PLAIN_MESSAGE);
}