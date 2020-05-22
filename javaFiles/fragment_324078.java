public void searchCustomer(String familyName) {
    for (int i = 0; i < customer.returnID(); i++) {
        customer search = search.get(i);
        if (search.returnFamilyName().equals(familyName)) {
            System.out.println("Index: " + i);            
            //removed  return i;
            return;
        }
    }
}