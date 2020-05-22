public interface Rule<T> {
  String execute(T dataProvider)
}


public interface DataProvider {

}


class RulesExecutor<T extends DataProvider> {

   public RulesExecutor(Map<String, List<Rule<T>>> documentToRuleListMap) {
   }

   public void executeRules(T dataProvider) {
     // some logic here 
   };
}