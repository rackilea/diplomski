String firstProdName = null;
String firstProdColor = null;
for (Product prod : productList) {
    if (firstProdName == null) // set the product name if not set
         firstProdName = prod.getName();
    if (firstProdColor == null) // set the product color if not set
         firstProdColor = prod.getColor();
    if (firstProdName != null && firstProdColor != null)
         break; // both have been found - terminate loop
}