double[] billtotal = new double[numBills];
int i = 0;

while (i < numBills) {
    tkw[i] = Double.parseDouble(JOptionPane.showInputDialog("Enter the Total 
    Kilowatts used: " + i));
    hours[i] = Double.parseDouble(JOptionPane.showInputDialog("Enter Number 
    of Hours a month: " + i));
    ckwh[i] = Double.parseDouble(JOptionPane.showInputDialog("Enter Cost per 
    Kilowatt hour (kWh): " + i));

    totalkwh[i] = tkw[i] * hours[i] * 30;
    totalconsu[i] = totalkwh[i] / 1000;
    billtotal[i] = totalconsu[i] * ckwh[i];
    i = i + 1;
}

i = 0;
while (i < numBills) {
    // Retrieve and display value at i (current element)
    System.out.println(i + " The Total cost of your Electricity Bill is $ " + billtotal[i]);
    i = i + 1;
}