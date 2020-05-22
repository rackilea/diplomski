public void showProblem()
{
    boolean aflag[] = ($VRc != null ? $VRc : $VRi())[2];
    try
    {
        int i = 0;
        aflag[0] = true;
        do
        {
            aflag[2] = true;
            if (i > 10)
            {
                System.out.println(i);
                i++;
                aflag[1] = true;
            } else
            {
                break;
            }
        } while (true);
        aflag[3] = true;
    }
    catch (Throwable throwable)
    {
        System.err.println(throwable);
        aflag[4] = true;
    }
    aflag[5] = true;
}