public <T extends IFlavor> void createCandy() {
    ICandy<T> candy= (ICandy<T>) AbstractCandy.buildCandy("Jolly Rancher");
    T flavor= candy.getFlavorForCandy(); 
    flavor.setName("Apple");            
    candy.addFlavor(flavor);  
}