int i = 0;
                    if (vList != null && vList.size() > 0)
                    {
                        for (VTr component : vList)
                        {

   btnAdd = new Button();
   btnAdd.setIcon(new ThemeResource("images/btnIncrease.png"));
                            btnRemove = new Button();
                            btnRemove.setIcon(new ThemeResource("images/btnDescrease.png"));
     GridLayout grid = new GridLayout(3, 3);
                    grid.addComponent(btnRemove, 0, 0);
                    grid.addComponent(lblIstMenge, 1, 0);
                    grid.addComponent(btnAdd, 2, 0);        
                            String transactionTypeName = component.getTransactionTypeName();
                            transaktionTable.addItem(new Object[]{++transaktionTableCounter + "", transactionTypeName,
                                "123123123123123", grid, "Bemerkung^^^"}, transaktionTableCounter);

                        }

                    }