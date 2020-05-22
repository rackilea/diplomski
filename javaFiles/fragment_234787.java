while(true)
{
    delta = System.nanoTime() - timer;

    if(delta >= 16666666) // 60 Hz
    {
        world.step(1.0f, 6, 2);

        processAndUpdateYourData();

        timer = System.nanoTime();
    }
}