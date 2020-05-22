public class SmokeCountSingleton {
    private static SmokeCountSingleton instance = null;
    private List<Long> smokeList = new ArrayList<Long>();
    protected SmokeCountSingleton() {

    }
    public static SmokeCountSingleton getInstance() {
        if(instance == null) {
            instance = new SmokeCountSingleton();
        }
        return instance;
    }
    public boolean canCreate() {
        cleanList()
        return (smokeList.size() <= 20)
    }
    public void didCreate(float duration) {
        //duration appears to be in seconds but we want it in milliseconds
        smokeList.add(System.currentTimeMillis() + duration*1000) 
    }
    private void cleanList(){
        //remove items from list who have exceeded their duration
            // have a value less than System.currentTimeMillis()
    }
}