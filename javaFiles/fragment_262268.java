public void tick()
{
    tickCount++;
    for (int i = 0; i < pixels.length; i++)
    {
        // where the image gets updated
        // pixels[i] = i + tickCount; // <-- it does exactly the same as the alternative below
        image.setRBG(i/WIDTH, i%WIDTH, i + tickCount);
    }
}