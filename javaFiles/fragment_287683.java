class SomeName {
    public SomeName(int variable) {
        ...
    }
}

class OtherName extends SomeName {
    public OtherName(float otherVariable) {
        this(*DEFAULT*, otherVariable);
    }

    public OtherName(int variable, float otherVariable) {
        super(variable);
        ...
    }
}