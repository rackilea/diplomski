class DeeLiteControlPanel extends JPanel
{
    public DeeLiteControlPanel()
    {
      setLayout(new GridBagLayout());
      GridBagConstraints gs=new GridBagConstraints();

      gs.anchor=GridBagConstraints.NORTHWEST;
      gs.fill=GridBagConstraints.BOTH; //or HORIZONTAL

      gs.gridx=0;
      gs.gridy=0;
      add(dataGroup,gs);

      gs.gridx=0;
      gs.gridy=1;
      add(viewGroup,gs);
      ....
     }
  }