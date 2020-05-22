class MoneyReward implements Reward {
   MoneyReward(Player gamer, Depository money) {
      ...
   }
   @Override 
   public execute() {
      ...
   }
}
...
class QuestReward implements Reward {
   MoneyReward(Player gamer, Map territory) {
      ...
   }
   @Override 
   public execute() {
      ...
   }
}