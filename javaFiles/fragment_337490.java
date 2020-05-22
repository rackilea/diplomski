public class DayInformation {

    @Embedded
    public PeriodInformation periodInformation;

    @Override
    public String toString() {
        return "DayInformation{" +
           "periodInformation=" + periodInformation +
           '}';
    }
}