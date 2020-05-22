abstract class A { 
    public abstract AdditionalStuff getAdditionalStuff();
}

class A1 extends class A { 
    @Override
    public AdditionalStuff getAdditionalStuff() {
       return new AdditionalStuffA1();
    }
}

class A2 extends class A { 
    @Override
    public AdditionalStuff getAdditionalStuff() {
       return new AdditionalStuffA2();
    }
}

class A3 extends class A { 
    @Override
    public AdditionalStuff getAdditionalStuff() {
       return new AdditionalStuffA3();
    }
}

abstract class AdditionalStuff {
    abstract void function(); 
}
class AdditionalStuffForA1 extends AdditionalStuff
class AdditionalStuffForA2 extends AdditionalStuff
class AdditionalStuffForA3 extends AdditionalStuff

class Implementation {
    List<A> aList; 
.... //add A1, A2, A3 to aList

    AdditionalStuff aS;

    for (A instance: aList) {
        aS = instance.getAdditionalStuff();
        aS.function()
    }

}