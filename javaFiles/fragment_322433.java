interface Marker {} //note that this is package private

public abstract class Mother<T extends Marker > {}

public class ChildA extends Mother<ChildA> implements Marker {}

public class ChildB extends Mother<ChildB> implements Marker {}