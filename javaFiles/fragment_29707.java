public class Sale extends Frame implements ActionListener, WindowListener {

    public Sale {
       add(custNameLbl);
       add(itemNameLbl);
       add(qtyLbl);
       ...
       // add the rest of your components
    }

    ...
    // rest of code
    ...

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                Sale sale = new Sale();
                sale.setVisible(true);
            }
        });
    }
}