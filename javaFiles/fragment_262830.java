public void searchCustomer(String familyName) {
    for (customer customer : CustomerList) {
        if (customer.returnFamilyName().equalsIgnoreCase(familyName)) {
            System.out.println(customer.returnFamilyName());
            break;
        }
    } 
}