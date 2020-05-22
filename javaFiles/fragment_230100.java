public void findMax(List<List<Route>> routeLists) {
        final IntWrapper dWrapper = new IntWrapper();
        routeLists.forEach(e-> {
            e.forEach(ee -> {
                dWrapper.value += ee.getDistance();    
            });

        });

        int d = dWrapper.value;

        ... doing some other operation with d
    }

 public class IntWrapper {
    public int value;
 }