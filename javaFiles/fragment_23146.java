class Orchestrator {
    URL[] otherAppClasspath = new URL[] { new URL("file:///vendor-api.jar"),
                                          new URL("file:///hibernate2.jar"),
                                          new URL("file:///code-extending-vendor-api.jar" };
    URLClassLoader otherAppLoader = new URLClassLoader(otherAppClasspath);

    URL[] yourAppClasspath = new URL[] { new URL("file:///myapp.jar"),
                                         new URL("file:///hibernate3.jar") };
    URLClassLoader yourAppLoader = new URLClassLoader(yourAppClasspath);

    public void start() {
        Method yourAppEntryPoint = yourAppLoader.findClass("com/company/Main").getMethod("start", new Class[] { Orchestrator.class } );
        yourAppEntryPoint.invoke(null, new Object[] { this });
    }

    public static void main(String[] args) {
        new Orchestrator().start();
    }

    // define some abstracted API here that can be called from your app
    // and calls down into classes in the other app
    public String getSomeResultFromOtherApp(int someArgument) {
        Method otherAppAPI = otherAppLoader.findClass("com/company/ExtendingAPIClass").getMethod("getSomeResult", new Class[] { Integer.class });
        return (String)otherAppAPI.invoke(null, new Object[] { someArgument });          
    }

}