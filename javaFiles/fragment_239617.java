class AnotherTorta extends Torta { ... }
class YetAnotherTorta extends CsTorta { ... }

AnotherTorta t3 = // whatever
YetAnotherTorta t4 = // whatever

tcs.retegez(t3);  
    // since AnotherTorta can't be cast to CsTorta, it chooses the Torta parameter
tcs.retegez(t4);
    // here, t4 can be cast to either a Torta or CsTorta parameter, so it chooses the subclass, CsTorta