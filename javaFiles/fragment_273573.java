protected void result(Object object)
{
    if (object.equals(1L))
    {
        gameScreen.setIntLives(3);
        gameScreen.setIntScore(0);
        System.out.println("Button Pressed");
    } else {
        // Goto main menut
    }
};