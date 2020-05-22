int countRows = 0;
    while(myRs.next()){
        countRows++;
        ...
    }

    if (countRows==0)
    {
        JOptionPane.showMessageDialog(this, "Not found");
    }