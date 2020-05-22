class CustomerModel {
    String phoneNumber
}

interface ICustomerOwner {
    CustomerModel getCustomer()
}

class CustomerRegistrationWorkflowActivity extends Activity implements ICustomerOwner {
    CustomerModel getCustomer()
    ...
}

class CustomerContactDataFragment // fragment1 where you edit the phone number.

class CustomerRegistrationSummaryFragment // fragment5 showing all data plus submit button)