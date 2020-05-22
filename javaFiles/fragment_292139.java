boolean running = true; //somewhere near the top of your class

...

//main launches the updater thread here

...

//inside updater's run() method:
for (String sURL : getURLs()){
    if(!running) return;
    pUpdater.process(getData(sURL));
}