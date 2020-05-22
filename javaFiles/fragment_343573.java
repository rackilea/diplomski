public double calculateTotal(){
    for(OrderItem currentItem:items){
        for(int i=0;i<currentItem.quantity;i++){
            total += currentItem.product.getPrice();
        }
    }
    return total;
}