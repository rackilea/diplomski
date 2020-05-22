public class PromoCollection {

    public static List<ParseObject> promotions = new ArrayList<ParseObject>();

    public static List<Boolean> isTriggered = new ArrayList<Boolean>();

    public static void add(ParseObject newObj) {
        for (ParseObject p : promotions) {
            if (p.getObjectId().equals(newObj.getObjectId())) {
                return; // Object already in list, do not add
            }
        }
        promotions.add(newObj); // Add new object
        isTriggered.add(false); // And respective boolean
    }

    public static void remove(ParseObject obj) {
        for (int i = 0; i < promotions.size(); ++i) {
            if (obj.getObjectId().equals(promotions.get(i).getObjectId())) {
                promotions.remove(i);
                isTriggered.remove(i);
                return;
            }
        }
    }

    public static void trigger(ParseObject obj) {
        for (int i = 0; i < promotions.size(); ++i) {
            if (obj.getObjectId().equals(promotions.get(i).getObjectId())) {
                isTriggered.set(i, true);
            }
        }
    }

    public static boolean isTriggered(ParseObject obj) {
        for (int i = 0; i < promotions.size(); ++i) {
            if (obj.getObjectId().equals(promotions.get(i).getObjectId())) {
                return isTriggered.get(i);
            }
        }
        throw new ArrayStoreException();
    }
}