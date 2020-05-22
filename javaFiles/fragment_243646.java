Properties props = new Properties();
props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
props.setProperty("org.omg.CORBA.ORBInitialHost", "*hostname*");
props.setProperty("org.omg.CORBA.ORBInitialPort", "*3700*");//default port
InitialContext ctx = new InitialContext(props);
FirstBeanRemote bean = (FirstBeanRemote) ctx.lookup("java:global/*EARNAME/EJBJARNAME*/FirstBean!*fullyqualifiedpackage*.FirstBeanRemote");