package com.company;

public class ShoppingEntry {
    private int quantity;
    private double price;

    public ShoppingEntry(){
        quantity = 0;
        price = 0;
    }

    public ShoppingEntry(int quantity, double price){
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}