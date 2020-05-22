timer = new Timer( waits, new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent mover)
    {
        // do the basic animation

        // 1. increment the labelX value
        // 2. set the location of the label

        // determine when to stop the animation 

        if (your stop condition is satisfied)
        {
            // stop the timeer
            // enable the roll button

            int die = (int)(random()*6+1);
            System.out.println(die + " was rolled.");

            //  auto restart the animation

            if (die > 4) // make it easier to test auto repeat
            {
                // Reset the component properties and restart the timer.
                // The code here is the same as the code for the roll button
                // that is why I suggested you create a method
            }
        }
    }
});