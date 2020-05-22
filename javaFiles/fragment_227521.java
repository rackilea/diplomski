public void setSalesTax(double tax)
{
    tax = saleAmount *.05;
    //tax = salesTax; <-- This line is wrong..
    this.salesTax= tax ;  // Change this line and it should work...
}

public void setInvoiceNumber(int inv)
{
    //inv = invoiceNumber ; --> Invalid setting
    this.invoiceNumber = inv; // Correct setting
}

public void setSaleAmount(double sale)
{
    //sale = saleAmount;  --> Invalid setting
    this.saleAmount = sale; // Correct setting
}