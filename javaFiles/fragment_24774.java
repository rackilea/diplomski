private void updateSalesAction()
{
    // Fetch the new sales details
    int productRef = Integer.parseInt(productRefEntryField.getText());
    int newSales = Integer.parseInt(productSalesEntryField.getText());
    if (productRef>0&&productRef<=MAX_PRODUCTS)
    {
        // Update the sales tables
        productSales[productRef] = newSales;
        totalSales = 0;
        for (int i = 1; i <= MAX_PRODUCTS; i++)
            totalSales += productSales[i];
        for (int i = 1; i <= MAX_PRODUCTS; i++)
            percentage[i] = calculatePercentage(productSales[i], totalSales);
    }
}