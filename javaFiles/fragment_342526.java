// (from jodatime source)
/**
 * Output the date time in ISO8601 format (yyyy-MM-ddTHH:mm:ss.SSSZZ).
 * 
 * @return ISO8601 time formatted string.
 */
@ToString
public String toString() {
    return ISODateTimeFormat.dateTime().print(this);
}