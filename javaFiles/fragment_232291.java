public enum SystemType {
    A, B;

    public Set<System> getSystems() {
        Set<System> systems = EnumSet.noneOf(System.class);
        for (System system : System.values()) {
            if (system.getType() == this) {
                systems.add(system);
            }
        }
        // you could also store this result
        // as an instance variable for caching.
        return systems; 
    }
}

public enum System {
    ConstOne(SystemType.A),
    ConstTwo(SystemType.A),
    ConstThree(SystemType.A),
    ConstFour(SystemType.B),
    ConstantFive(SystemType.B);

    private final SystemType systemType;

    private System(final SystemType systemType) {
        this.systemType = systemType;
    }

    public int getNumber() {
        return ordinal() + 1;
    }

    public SystemType getType() {
        return systemType;
    }

}