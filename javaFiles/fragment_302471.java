public class SwissCheese
{//Can't have swiss cheese without some holes
    public Leak[] myHoles;

    public SwissCheese()
    {//Gotta have a Factory to make my holes
        LeakFactory _holeDriller = new LeakFactory()
    // Now, let's get the holes and store them.
        myHoles = new Leak[1000];

        for (int i = 0; i++; i<1000)
        {//Store them in the class member
            myHoles[i] = _holeDriller.createLeak();
        }

    // Yay! We're done! 

    // Buh-bye LeakFactory. I don't need you anymore...
    }
}