public void startApplication()
{
    mf = new mainFrame();
    mf.startApp();
    gui = new Interface();
    gui.makeLayout();
    mf.add(gui); // here is get's added
}