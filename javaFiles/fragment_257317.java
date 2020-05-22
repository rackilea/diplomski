public class DateTwo {
    private int dayNumber;

    // Constructor
    public DateTwo(int dayNumber) {
        setDayNumber(dayNumber); // Reuses setter to enforce validation
    }

    // Setter
    public void setDayNumber(int dayNumber) {
        if (dayNumber < 1 || dayNumber > 7)
            throw new IllegalArgumentException("Invalid day number: " + dayNumber);
        this.dayNumber = dayNumber;
    }

    // Getter
    public int getDayNumber() {
        return this.dayNumber;
    }
}