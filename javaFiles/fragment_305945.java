String customerType;
double subtotal;
try {    
//System.out.print("Enter customer type (r/c): ");
    customerType = getValidCustomerType(sc);
    System.out.print("Enter subtotal:   ");
    subtotal = sc.nextDouble();
} catch (InputMismatchException e) {
    sc.next();
    System.out.println("Error! Invalid number. Try again \n");
    continue;
}