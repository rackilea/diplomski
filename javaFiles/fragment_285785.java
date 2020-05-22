public String check(String customerType, String customerDetails, String addressDetails) 
{

    try {
        CustomerType customerType = CustomerType.valueOf(type);
    } catch (IllegalArgumentException e) {
        return null;
    } 

    // Java12 - Use Switch Expressions
    String result = 
        switch (customerType) {
            case CUSTOMER1 -> formatCustomer1(customerDetails, addressDetails);
            case CUSTOMER2 -> formatCustomer2(customerDetails, addressDetails);
            // etc
         }


    // Up to Java 11 - Use normal Switch statement
    String result = null;
    switch (customerType) {
        case CUSTOMER1: result = formatCustomer1(customerDetails, addressDetails);
                        break;
        case CUSTOMER2: result = formatCustomer2(customerDetails, addressDetails);
                        break;
        // etc
     }