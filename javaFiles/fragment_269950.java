public boolean vegStatus(){
    for(PizzaTopping topping : topList) {
        if(!topping.isVeg())
            return false;
    }

    return true;
}