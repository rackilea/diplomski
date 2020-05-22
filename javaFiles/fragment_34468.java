public class DataAccess {
    List<FacilityInfo> fac = new ArrayList<FacilityInfo>();

    public void initializeFac() {
        fac.add(new FacilityInfo(1,2,10,"conference"));
        // etc.
    }
}