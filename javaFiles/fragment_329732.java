package com.sof.test;


public class Detail implements Comparable {

    private String Name;
    private String Model;
    private int InStock;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getInStock() {
        return InStock;
    }

    public void setInStock(int inStock) {
        InStock = inStock;
    }
    @Override
    public int compareTo(Object o) {

         if((((Detail)o).getInStock())*(((Detail)o).getPrice())  > (this.getInStock())*(this.getPrice())) 
         {

             return -1;
         }
        return 1;
    }

}