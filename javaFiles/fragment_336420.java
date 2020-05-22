Object[] arr = (Object[]) query.getSingleResult();
if(arr.length == 0) {
    product = null;
} else {
    product = (InventoryProduct)arr[0];
}