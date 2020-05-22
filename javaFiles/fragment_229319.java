class File {
    private FileEventListener listener; // <- create getter/setter for this

    public finish() {
        listener.onFileFinished();
    }
}


class FileView extends ViewPart implements EventProxyListener {
    private EventProxy proxy = new EventProxy();

    // This is where you register this FileView as a listener to events from the proxy instance
    public FileView() {
        proxy.setListener(this); // <- This is ok because FileView implements EventProxyListener
    }

    // Implements onFinished, described in the EventProxyListener interface
    public void onProxyFinished() {
        // EventProxy has reported that it is done
    }
}

// This is the MiM-class that will clobber your code. I urge you to reconsider this design
class EventProxy implements FileEventListener {
    private EventProxyListener listener; // <- Create getter/setter for this
    private File file = new File();

    public EventProxy {
        file.setListener(this);
    }

    public void onFileFinished() {
        listener.onProxyFinished();
    }
}

interface EventProxyListener {
    public void onProxyFinished();
}

interface FileEventListener {
    public void onFileFinished();
}