public class CustomComparator implements Comparator<DummyPage> {
    @Override
    public int compare(DummyPage o1, DummyPage o2) {
        return Month.valueOf(o1.getMonth().toUpperCase()).compare(Month.valueOf(o2.getMonth().toUpperCase()));
    }
}