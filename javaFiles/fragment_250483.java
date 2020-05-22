public class SearchDB{  // class names begin with upper-case

  public SearchDB(Gui gui){  // no more pseudo-constructors! And pass in Gui object
    HandlerClass handler = new HandlerClass();
    gui.getBtnUpdate().addActionListener(handler); // call method
  }

  private class HandlerClass implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent event) {
        // String cstmrSearch = (String) Gui.cbCustomer.getSelectedItem();
        String cstmrSearch = gui.getSelectedCustomer(); // give Gui this method
        System.out.println("Selected Customer is :"+cstmrSearch);
    }

  }
}