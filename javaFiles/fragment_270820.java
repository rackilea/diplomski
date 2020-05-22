public void forLoopReplacement(IActionStrategy strategy, IList<Pojoclass> projo){
   for(Pojoclass a : listofPojo){
      strategy.doActionOn(a);
   }
}

public interface IActionStrategy {
   public void doAction(Pojoclass param);
}