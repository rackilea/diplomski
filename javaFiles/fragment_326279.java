public class GraduationCeremonyComparator implements Comparator<GraduationCeremony> {
    public int compare(GraduationCeremony o1, GraduationCeremony o2) {
        int value1 = o1.campus.compareTo(o2.campus);
        if (value1 == 0) {
            int value2 = o1.faculty.compareTo(o2.faculty);
            if (value2 == 0) {
                return o1.building.compareTo(o2.building);
            } else {
                return value2;
            }
        }
        return value1;
    }
}