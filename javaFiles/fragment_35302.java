public class City {

    private static volatile City instance;

    public static City getInstance() {
        if( instance == null ) {
            synchronized (City.class) {
                if( instance == null ) {
                    instance = new City();
                }
            }
        }
        return instance;
    }

    private City() {
      ... construct city here ....
    }

    // your City instance methods here (non-static)
    ....

}