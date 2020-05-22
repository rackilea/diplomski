public View_EditCustomer(Model_Customer cust) {

        initComponents();
        customer = cust;
        txtname.setText(customer.GetFName());
        txtSecondName.setText(customer.GetLName());


    }