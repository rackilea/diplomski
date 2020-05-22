Window myWindow = ....
// ...
GraphicsConfiguration config = myWindow.getGraphicsConfiguration();
GraphicsDevice myScreen = config.getDevice();
GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
// AFAIK - there are no guarantees that screen devices are in order... 
// but they have been on every system I've used.
GraphicsDevice[] allScreens = env.getScreenDevices();
int myScreenIndex = -1;
for (int i = 0; i < allScreens.length; i++) {
    if (allScreens[i].equals(myScreen))
    {
        myScreenIndex = i;
        break;
    }
}
System.out.println("window is on screen" + myScreenIndex);