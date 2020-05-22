public void itemStateChanged( ItemEvent event )
    {
            total = 10.00;
            // TO BE COMPLETED
            String selection = "";
            if (chkCheese.isSelected()) 
                total = total + CHEESE_COST;
            if (chkChicken.isSelected()) 
                total = total + CHICKEN_COST;
            if (chkTomato.isSelected()) 
                total = total + TOMATO_COST;



            if (chkCheese.isSelected() && chkChicken.isSelected() && chkTomato.isSelected()) 
            {
                selection = "Cheese with Chicken and Tomato ";
                order += selection;
            }
            else if(chkCheese.isSelected() && chkChicken.isSelected())
            {
                          order += "Cheese with Chicken ";
            }
            else if(chkCheese.isSelected() && chkTomato.isSelected())
            { 
                        order += "Cheese with Tomato ";
            }

            else if (chkChicken.isSelected() && chkTomato.isSelected())
            {
                      order += "Chicken with Tomato ";
            }
            else if(chkCheese.isSelected())
            {
                        order += "Cheese ";     
            }
            else if (chkChicken.isSelected())
            {
                      order += "Chicken ";
            }
            else if (chkTomato.isSelected())
            {
                      order += "Tomato ";
            }


        priceLabel.setText("Price of pizza is: $" +  Double.toString(total));
        grandTotalLabel.setText("Total income is: $" +  Double.toString(grandTotal));

    }