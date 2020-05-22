public class CookieCounter {
    private static CookieCounter instance;
    int count = 0;
    public static CookieCounter getInstance() {
        if(instance == null) {
            instance = new CookieCounter();
        }
        return instance;
    }

    public void increaseCount(int amount) {
        count += amount;
    }

    public int getCount() {
        return count;
    }
}