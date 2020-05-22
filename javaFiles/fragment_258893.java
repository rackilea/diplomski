public void mainLoop()
{
    Class2 cls2 = new Class2();
    while(someCondition == true)
    {
        frames++
        if(frames == 200)
        {
            key = 5
            run = false;
        }

        if(frames == 400)
        {
            key = 10
            run = true;
        }
        cls2.printVariables(key);
    }
}