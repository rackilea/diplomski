public class searchDB{

public void searchDB(){

    HandlerClass handler = new HandlerClass();
    Gui.btnSearch.addActionListener(handler); //error in this line

}
private class HandlerClass implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent event) {
        // TODO Auto-generated method stub
        String cstmrSearch = (String) Gui.cbCustomer.getSelectedItem();
        System.out.println("Selected Customer is :"+cstmrSearch);
    }


}
}