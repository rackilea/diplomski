public InsuredPackage(int weight, char shippingCost){
    if(super.shippingcost <= 1){
        super.shippingcost += 2.45;
    }
    else if( (super.shippingcost > 1.00) && (super.shippingcost <= 3.00) ){
        super.shippingcost += 3.95;
    }
    else if( super.shippingcost > 3 ){
        super.shippingcost += 5.55;
    }
}