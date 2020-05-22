int somevalue = ...;//anything
SetScreenSize(somevalue); //compiles

private void SetScreenSize(int Screen)
{
    switch (Screen)
    {
        case ScreenSizeClass.Large:
            //Do Logic
            break;
        case ScreenSizeClass.Small:
            //Do Logic
            break;
        default: 
            // something else, what to do??
            break;
    }
}