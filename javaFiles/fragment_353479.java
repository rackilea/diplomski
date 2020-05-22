String str = "";        
    if (hundredDollars == 1)
        str += String.format(%10s %-20s%n",hundredDollars,"hundred dollar bill");
    else if (hundredDollars > 1)
        str += String.format(%10s %-20s%n",hundredDollars,"hundred dollar bills");
    JOptionPane.showMessageDialog(null, str, originalAmount, JOptionPane.INFORMATION_MESSAGE));