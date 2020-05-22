public Product findProduct(int id)
{    
    for (Product item : stock) {  
        if (item.getID() == id) {
            return item;
        }
    }
    return null;    
}