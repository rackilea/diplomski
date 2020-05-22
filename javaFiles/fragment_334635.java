public void execute() {
    List<Condition> conditionChains = ....

    for(Condition condition : conditionChain){
          if(condition.notSatisfied(context)){
               //here use condition#toString() to explain what wasn't satisfied. 
               //Could use another method like getDescrption() instead...
               LOGGER.info(condition + " not satisfied.");
              return;
          }
          condition.execute(context);
    }
}