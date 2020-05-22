// Added "implements E" and provided trivial interface E
// to allow (for E : ...) to work in main(...).
public class CountDown implements E, Comparable<CountDown> {
  private int hour;
  private int minute;

  // Removed unnecessary "throws Exception" specifier
  public CountDown(int hour, int minute) {
    // Previous logic incorrect.  Should throw exception if either hour
    // OR minute is out of range.
    if (hour > 23 || hour < 0 || minute > 59 || minute < 0) {
      throw new IllegalArgumentException("Horas ou minutos invalidos");
    } else {
      this.hour = hour;
      this.minute = minute;
    }
  }

  // Corrected capitalisation to make bean compliant name.
  // Not strictly required.
  public int getHour() {
    return this.hour;
  }

  // Corrected capitalisation to make bean compliant name.
  // Not strictly required.
  public int getMinute() {
    return this.minute;
  }

  @Override
  public int compareTo(CountDown other) {
    // Simplified logic.  Made sort by hours, then by minutes.
    int cmp = Integer.compare(this.getHour(), other.getHour());
    if (cmp == 0)
      cmp = Integer.compare(this.getMinute(), other.getMinute());
    return cmp;
  }

  // Really should have equals(...) method if instances are comparable.
  // Also required if we want to use instances in a HashSet
  @Override
  public boolean equals(Object o)
  {
    if (this == o)
      return true;
    if (o instanceof CountDown)
    {
      CountDown other = (CountDown)o;
      // Ensures that this logic is consistent with compareTo(...)
      return this.compareTo(other) == 0;
    }
    return false;
  }

  // Really should have hashCode() if we have equals.
  // Also required if we want to use instances in a HashSet
  @Override
  public int hashCode()
  {
    // Collision-free hash code given logic in constructor.
    return this.hour * 60 + this.minute;
  }

  // Required to show a sensible value for System.out.print(...) etc
  @Override
  public String toString()
  {
    return String.format("%s[%02d:%02d]", getClass().getSimpleName(),
        this.getHour(), this.getMinute());
  }
}