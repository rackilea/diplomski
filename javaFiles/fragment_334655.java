class Dozens {
    int[] dz = {1,2,3,4,5,6,7,8,9,10,11,12};
}

public class Eggs{
    public static void main(String[] args){
        Dozens[] da = new Dozens[3];  // +1 object, the array containing 3 nulls
        da[0] = new Dozens();         // +2 objects, Dozens and the array in Dozens.dz
        Dozens d = new Dozens();      // +2 objects, Dozens and the array in Dozens.dz
        da[1] = d;                    // +0, d now has two refs to it
        d = null;                     // +0, d now has one ref to it
        da[1] = null;                 // -2, d now has no refs to it so both d and its internal array become available for GC
        // do stuff
    }
}