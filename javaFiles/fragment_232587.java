public class Random extends Applet {
    TextArea t;
    int[] random;
    int[] hveOft;
    int i;
    int[] k = this.hveOft;
    @Override
    public void init()
    {
        this.t = new TextArea(25, 25); //Made the TextArea a bit bigger.
        this.add(this.t);

        this.random = new int[10]; //Defined the random array as size 10

        for(this.i=0; this.i<100; this.i++) { //looping from 0 to <100 will give you 100 random items
            //Used Math.random, but this is the same idea as Karci10
            this.random[(int)(Math.random() * 10)]++; 
        }

        for(int k=0; k<10; k++) { //Again, looping from 0 to get all 0-9 numbers
            //Don't forget to use k in this loop, not i as k is the one you're dealing with here.
            this.t.appendText("Talan " + k + " kom " + this.random[k] + " sinnum" + "\n");
        }

    }
}