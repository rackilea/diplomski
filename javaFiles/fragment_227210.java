String pCode = "";
double pPrice = 0;
int pQuantity = 0;

if(strToken.hasMoreTokens()){
    pCode = strToken.nextToken();
    System.out.println("pCode Works");
}
if(strToken.hasMoreTokens()){
    pPrice = Double.parseDouble(strToken.nextToken());
    System.out.println("pPrice Works");
}
if(strToken.hasMoreTokens()){
    pQuantity = Integer.parseInt(strToken.nextToken());
    System.out.println("pQuantity Works");
}
products.add(new Product(pCode,pPrice,pQuantity));
System.out.println("Storing Works");