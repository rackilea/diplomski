public interface WorldObject {...}
public interface Organism extends WorldObject {...}
public interface Plant extends Organism {...}
public interface Animal extends Organism {...}
public interface Eater<T> {...}

public class Stone implements WorldObject {...}
public class Seaweed implements Plant {...}
public class Sprat implements Animal, Eater<Seaweed> {...}