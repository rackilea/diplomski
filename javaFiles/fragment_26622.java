public void actionPerformed (ActionEvent e)
{
    if (clickm == 11)
    {
        clicky = clicky + 1;
        clickm = 0;
        System.out.println(clickm);
        System.out.println(clicky);
        Main m = new Main();   // ********* here **************
        m.makeCenter(clicky, clickm);
        m.makeNorth();
        m.makeEast();
    }