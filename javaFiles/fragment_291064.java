for(int i = 0; i < range; i++)
{
    productRange[i] = new Product();
    productRange[i].setProductCode(codeDataScan.next());
    productRange[i].setPricePerUnit(Integer.
                                    parseInt(priceDataScan.nextLine()));
}