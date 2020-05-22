public class ageCalculator {
    String yearText;
    public ageCalculator(int yearBirth, int yearTo) {
        if (yearBirth > yearTo) {
            int year = (yearBirth - yearTo);
            yearText = String.valueOf(year);
        } else {
            int year = (yearTo - yearBirth);
            yearText = String.valueOf(year);
        }
    }
    public String getYear() {
        return yearText;
    }
}