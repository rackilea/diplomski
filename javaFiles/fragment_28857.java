do{
        purchaseAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter the Item Purchase Amount"));

        if(onepty.budgetAmountVerify(purchaseAmount)){

        itemNo ++;

        itemCheck = JOptionPane.showConfirmDialog(null,
                             "Would you like to Enter More Items?", "Say Yes or No", JOptionPane.YES_NO_OPTION); 
}
while(itemCheck == JOptionPane.YES_OPTION)