// Again, this is not actually Java, just pseudo code

// Create a place to put your restructured data
Collection theStacks = new Collection();
theStacks.push( new Stack<>() );

Stack<> whichStack = null;
String[] cargo = ecf.getArray("ConstructionData6.txt");

for (int k=0; k<cargo.length; k++) {

    // Pick the correct stack to put stuff in
    if (the last stack in theStacks  has length > 7) {
        // If the most recent stack has 7 things in it, make a new one
        theStacks.push( new Stack<>() );
    }
    whichStack = the last stack in theStacks;

    // Push it, push it real good
    whichStack.push(cargo[k]);
}