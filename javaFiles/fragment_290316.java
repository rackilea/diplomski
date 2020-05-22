enum Stature {
    tall, average, small;

    public static Stature[] getSortedVaules() {
        Stature[] statures = values();
        Arrays.sort(statures, EnumByNameComparator.INSTANCE);
        return statures;
    }

    private static class EnumByNameComparator implements Comparator<Enum<?>> {

        public static final Comparator<Enum<?>> INSTANCE = new EnumByNameComparator();

        public int compare(Enum<?> enum1, Enum<?> enum2) {
            return enum1.name().compareTo(enum2.name());
        }

    }

}

public class StatureTest {

    @Test
    public void getSortedValues() {
        Stature[] normalValues = Stature.values();
        Assert.assertEquals(Stature.tall, normalValues[0]);
        Assert.assertEquals(Stature.average, normalValues[1]);
        Assert.assertEquals(Stature.small, normalValues[2]);

        Stature[] sortedVaules = Stature.getSortedVaules();
        Assert.assertEquals(Stature.average, sortedVaules[0]);
        Assert.assertEquals(Stature.small, sortedVaules[1]);
        Assert.assertEquals(Stature.tall, sortedVaules[2]);
    }
}