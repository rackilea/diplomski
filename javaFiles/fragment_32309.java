public class Staff implements Weapon {} 
public class Sword implements Weapon {} 

public abstract class Player {
    private List<Weapon> weaponInventory;
    protected final void addWeapon(Weapon weapon) {
         weaponInventory.add(weapon)
    }
 }

 public class Wizard extends Player {
     public void add(Staff staff) {
         addWeapon(staff);
     }
 }

 public class Warrior extends Player {
     public void add(Sword sword) {
         addWeapon(sword);
     }
 }