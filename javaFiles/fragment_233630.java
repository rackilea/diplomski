// loop forever until TheMethod() succeeds

while (true)
{
    try
    {
        TheMethod();
        break;
    }

    catch (Exception e)
    {
    }
}