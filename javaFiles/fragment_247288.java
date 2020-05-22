public class Player {
   private String name;
   private List<StatAction> statActionList = new ArrayList<>();

   // ....

   public String getName() {
      return name;
   }

   public void addStatAction(StatAction statAction) {
      statActionList.add(statAction);
   }

   public void removeStatAction(StatAction statAction) {
      statActionList.remove(statAction);
   }

   public void removeLastStatAction() {
      if (statActionList.size() > 0) {
         statActionList.remove(statActionList.size() - 1);
      }
   }

   //.....

}