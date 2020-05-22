// this should be of type Thread not LoadThread
private Thread img_loader;
...
// don't create the loader thread inside of LoadThread
img_loader = new Thread(new LoadThread(/* some data structures */));
img_loader.start();