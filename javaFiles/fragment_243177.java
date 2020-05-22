public interface Core {

    sendFiles(List<File> files);
    registerProgressListener(ProgressListener listener);            
    registerStatusListener(StatusListener listener);
    registerMessageListener(MessageListener listener);
}