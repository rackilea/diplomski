class A
{
   public enum UnitType { TANK, TRIKE, COMMANDO };

   public void reset (UnitType type); 

   //or even:
   public void reset (Set<UnitType> types); 

}