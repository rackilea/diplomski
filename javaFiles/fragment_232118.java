public abstract class Organism<T extends Organism<T>> extends GeneCarrier<T> {
    //...
}

public final class Human extends Organism<Human> {
    public void foo(){
        Gene<Human> g; // valid
    }
}