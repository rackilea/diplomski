String Svalue = "1101300045";
    double Dvalue = Double.parseDouble(Svalue);

    NumberFormat nf = NumberFormat.getInstance();
    nf.setGroupingUsed(false);
    System.out.println("Dvalue: " + nf.format(Dvalue));

    Dvalue++;
    Svalue = nf.format(Dvalue);
    System.out.println("Svalue: " + Svalue);