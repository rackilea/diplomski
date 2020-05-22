public class RandomDemo { // arbitrary example class name
    // lots of class related stuff may be here...

    // still inside the class scope...
    // private is a good idea unless an external method needs to change it
    private Random randnum = new Random(123456789L);
    // the seed guarantees it will always produce the same sequence
    // of pseudo-random values when the next methods get called
    // for unpredicable sequences, use the following constructor instead:
    // private Random randnum = new Random();

    // lots of code may be here...

    // publicly exposed instance method for getting random number
    // from a sequence determined by seed 123456789L
    // in the range from 0 through i-1
    public int randnum(int i) {
        // don't set the seed in here, or randnum will return the exact same integer
        // for the same value of i on every method call
        // nextInt(i) will give the next value from randnum conforming to range i
        return randnum.nextInt(i);
    } // end randnum

    // lots of more code may be here...

} // end class RandDemo