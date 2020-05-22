public class UIDProvider {
    private static int uid = 0;

    public static synchronized boolean isDifferentThanStoredUid(int uid) {
        if (this.uid != uid) {
            this.uid = uid; // assign the new value here
            return true;
        } else {
            return false;
        }
    }
}