button.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e) {
        int qty;
        double price;
        double cost;
        qty = Integer.parseInt(qtyTF.getText());
        price = Double.parseDouble(priceTF.getText());
        cost = price * qty * 1.065;
        this.add(msgLbl, null);
        msgLbl.setText("The cost of this " + "transaction is: $" + cost);
        custNameTF.setText("");
        itemNameTF.setText("");
        qtyTF.setText("");
        priceTF.setText("");

        // System.out.println(cost);

        // TODO Auto-generated method stub

    }
});