Boolean quit = false;
while (!quit)        //or do-while
{
    int opt = menu();
    switch(opt)
    {
        //other cases...
        case 4:
            quit = true;
    }
}