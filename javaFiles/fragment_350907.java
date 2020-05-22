public double priceFor(int quantity) {
    if (quantity < 0) {
        throw new IllegalArgumentException("Quantity cannot be negative");
    }
    if (quantity >= bulkQuantity) {
        int numberOfBulkQuantities = 0;
        for (int i = quantity - bulkQuantity; i >= 0; i -= bulkQuantity) {
            numberOfBulkQuantities++;
            quantity -= bulkQuantity;
        }
        return numberOfBulkQuantities * bulkPrice + quantity * price;
    }
    return quantity * price;
}