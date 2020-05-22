public void actionPerformed(ActionEvent click)  {

    Object source = click.getSource();

    if(source == farmerbutton)
    {           
    String farmertext = "Blocks a Farmer cannot break:" +"\r\n" +"\r\n" + "Any type of logs" + "\r\n" + "Stone" + "\r\n" + " Coal ore" + "\r\n" + "Iron ore" + "\r\n" + "Gold ore" + "\r\n" + "Diamond Ore" + "\r\n" + "Redstone ore" + "\r\n" + "Lapiz ore";  
    JOptionPane.showMessageDialog(farmerbutton,farmertext,"The Farmer Class",JOptionPane.PLAIN_MESSAGE);
    }


    if(source == minerbutton)
    {
    String minertext = "null miner";
    JOptionPane.showMessageDialog(minerbutton,minertext, "The Miner Class", JOptionPane.PLAIN_MESSAGE);
    }

    if(source == blacksmithbutton)
    {
    //blacksmith
    String blacksmithtext ="null blacksmith";
    JOptionPane.showMessageDialog(blacksmithbutton,blacksmithtext, "The BlackSmith Class", JOptionPane.PLAIN_MESSAGE);
    }

    if(source == lumberjackbutton)
    {
    //lumberjack
    String lumberjacktext = "null lumberjack";
    JOptionPane.showMessageDialog(lumberjackbutton, lumberjacktext, "The Lumberjack Class", JOptionPane.PLAIN_MESSAGE); 
    }
}