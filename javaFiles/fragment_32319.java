class WeaponVisitor {
   void visit(Sword aSword) { }
   void visit(ChargeGun aGun) { }
}

// add accept method to your Weapon interface
interface Weapon {
  ...
  void accept(Visitor v);
}

// then implement accept in your implementing classes
class Sword {
...
   @Override
   void accept(Visitor v) {
      v.visit(this); // this is instanceof Sword so the right visit method will be picked
   }
}

// lastly, extend Visitor and override the methods you are interested in
class OnlySwordVisitor extends Visitor {
     @Override void visit(Sword aSword) {
      System.out.println("Found a sword!");
      aSword.wipeBloodfromSword();
     }
 }