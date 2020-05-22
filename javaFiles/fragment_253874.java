public void findCustomer()
{
    String firstname = findCustomerField.getText();

    if(!"".equal(firstname))
    {
        User user = list.findById(firstname);
        if(user != null)
        {
            outputText.setText(user.getFirstName());
        }
    }
}