public class MyStandardListenerService extends StandardManager implements MyListenerServiceInterface {

private static final long serialVersionUID = 1L;

protected synchronized void performStartupProcess() throws ManagerException {

    VersionEventListenerAdapter versionEventListenerAdapter = new VersionEventListenerAdapter(getName());
    getManagerService().addEventListener(versionEventListenerAdapter, VersionControlServiceEvent.generateEventKey(VersionControlServiceEvent.NEW_VERSION));

}

public static MyStandardListenerService newMyStandardListenerService() throws WTException {
    MyStandardListenerService instance = new MyStandardListenerService();
    instance.initialize();
    return instance;
}