List<ApplicationWithEnvironments > AppWithEnvlist = new ArrayList<ApplicationWithEnvironments >();        

    for(ApplicationDTO d: allApplication) {
        ApplicationWithEnvironments appWithEnv = new ApplicationWithEnvironments();

        Application a = new Application();

        a.set...

        appWithEnv.setApplication(a);


        for(EnvironmentDTO en: d.getEnvironment())
        {
            Environment e = new Environment();
            e.set...
            appWithEnv.addEnvironment(e);
        }

        AppWithEnvList.add(appWithEnv);
    }

    ArrayList<MyModel> obj= new ArrayList<MyModel>();
    MyModel mm = new MyModel();
    mm.setAppWithEnvList(AppWithEnvList);
    obj.add(mm);
    return obj;