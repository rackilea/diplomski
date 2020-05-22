public InsuredPackage(int weight, char shippingMethod){
    super(weight,shippingMethod);
    if(shippingcost <= 1){
        shippingcost += 2.45;
    }
    else if( (shippingcost > 1.00) && (shippingcost <= 3.00) ){
        shippingcost += 3.95;
    }
    else if(shippingcost > 3 ){
        shippingcost += 5.55;
    }
}