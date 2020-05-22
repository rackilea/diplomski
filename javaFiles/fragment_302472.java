public class SwissCheese
{//Can't have swiss cheese without some holes
    public Leak[] myHoles;

    public SwissCheese()
    {//Now, let's get the holes and store them.
        myHoles = new Leak[1000];

        for (int i = 0; i++; i<1000)
        {//WOW! I don't even have to create a Factory... 
        // This is SOOOO much prettier....
            myHoles[i] = new LeakFactory().createLeak();
        }
    }
}