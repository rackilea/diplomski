abstract class CreatureProperties {
   protected String id = "";
   protectd int propertyValue = 0;
   public void actOn(BaseMonster);
  // plus setter and getter
}

public RegenerationProperty implements CreatureProperties {
   final public REGENERATION_ID = "Regeneration";
   int regenerationValue = 0;

   public RegenerationProperty(int value){
      id = REGENERATION_ID;
      propertyValue= value;
   }

   public void actOn(BaseMonster monster){
      monster.setHitPoint(monster.getHitPoints()+propertyValue);
   }
}

in the BaseMonster class, you manage a set of MonsterProperty, initially empty.

    class BaseMonster {
       protected List<CreatureProperties> properties = 
         new ArrayList<CreatureProperties>();
       // plus management of propeties : add remove, iterator...

       public void update(){
          // perform all properties-linked update to monster
          foreach (CreatureProperty property : properties){
             property.actOn(this);
          }
       } 
    }