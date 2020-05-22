public class SingletonFactory {
    public static InterestingInterface produce(int id) {
        switch(id) {
            case 1:
                return SingletonA.getInstance();
            case 2:
                return SingletonB.getInstance();
            case 3:
                return new C();
            default:
                return null;
        }
    }
}