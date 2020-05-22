public class CommonAPIThreadLocalStorageManager {
    private static CommonAPIThreadLocalStorageManager instance;

    // Typical singleton private constructor, static getInstance here

    private ThreadLocal<String> userID = new ThreadLocal<String>();

    public String getUserID() {
        return userID.get();
    }

    public void setUserID(String userID) {
        this.userID.set(userID);
    }