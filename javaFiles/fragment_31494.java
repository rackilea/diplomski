class Main{
    Main(Object input){}

    public static Main create( Object input ) {
        if (input.fullfillsSomeCond()) { return new SubA(input); }
        if (input.fullfillsSomeOtherCond()) { return new SubB(input); }
        // You might want to handle the case where input does not 
        // meet any of the above criteria.
        throw new IllegalArgumentException("input must be either A or B!");
    }
}