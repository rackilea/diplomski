int delay = 1000;
if(System.currentTimeMillis() > lastClicked + delay)
{
    //do your click
    lastClicked = System.currentTimeMillis();
}