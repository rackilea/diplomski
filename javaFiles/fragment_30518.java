public class cCleanThread implements Runnable {

    private final UserList localUserList;

    public cCleanThread(String threadName, UserList mUserList) {
        this.localUserList = mUserList;
        //...
    }

    public void run() {
        //...
        localUserList.Clean(); 
    }
}