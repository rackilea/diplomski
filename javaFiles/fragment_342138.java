String [] namelist=DocBuilderClass.username();
    for(int i=0;i<namelist.length;i++)
    {

        String abc=namelist[i];

        googlebox.sendKeys(abc);
        googlebox.clear();
        googlebox.sendKeys(namelist[i]);


    }