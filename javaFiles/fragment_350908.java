if (quantity >= bulkQuantity && bulkQuantity > 0) {
    int numberOfBulkQuantities = 0;
    for (int i = quantity - bulkQuantity; i >= 0; i -= bulkQuantity) {
        numberOfBulkQuantities++;
        quantity -= bulkQuantity;
    }
    return numberOfBulkQuantities * bulkPrice + quantity * price;
}