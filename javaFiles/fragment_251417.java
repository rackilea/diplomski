public class Logic {
    final static private  ArrayList<Logic> logics;


    static {
        try {
            logics = new ArrayList<Logic>(Arrays.asList(new Logic(jo.get("cif").toString())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // rest of your class...
}