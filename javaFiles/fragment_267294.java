public abstract class PizzaStore {

    protected PizzaBin bin;

    //customer orders a pizza
    public Pizza orderPizza(String type) {
        //maybe we already have one...
        Pizza pizza = HeresOneWeMadeEarlier(type);
        if (pizza !=null) return pizza;
        //nope, we have none, so we have to make one.
        pizza = createPizza(type);
        pizza.prepare(); // other methods follow
        return pizza;
    }

    //customer returns a pizza
    public void ReturnPizza(Pizza pie) {
     if(!pie.HasAllSlices()){
       throw new CannotReturnPartiallyEatenPizzaException();
      }
     //hmm. maybe we can re-use this later on...
     bin.store(pie);        
    }

    //check if we have a pizza in the bin.
    protected Pizza HeresOneWeMadeEarlier(String type){
        if(bin.contains(type)){
          //we never said this was a *nice* pizza store!
            return bin.takeOutAndDustOff(type);
        }
        else{
          return null;
        }
    }

    protected abstract class Pizza createPizza(String type);

}