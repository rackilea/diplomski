Properties containerProps = new jade.util.leap.Properties();
containerProps.setProperty(Profile.AGENTS, "annoyer:myTest.MyAgent");

Profile containerProfile = new ProfileImpl(containerProps);

Runtime.instance().setCloseVM(false);
Runtime.instance().createMainContainer(containerProfile);