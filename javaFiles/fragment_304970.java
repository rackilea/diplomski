while(it.hasNext()){
    p = it.next();
    if (p.getId().equals(productId)) {
         it.remove();
         System.out.println("Successfully removed the product " + pid);
         return;
    }
}
throw new ProductNotFoundException ("No Such Product");