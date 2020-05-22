class SomeType{

    private Object comparisonField;

    public SomeType(Object comparisonValue){
        this.comparisonField = comparisonValue;
    }

    @overrides
    public int getHashCode(Object other){
        if(this.comparisonField == null)
            return super.getHashCode();

        return this.comparisonField.getHashCode();
    }

    @overrides
    public boolean equals(Object other){
        if(comparisonField == null || other == null)
           return super.equals(other);

        return comparisonField.equals(((SomeType)other).comparisonField);
    }
}