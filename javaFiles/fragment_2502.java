public class Worktime
{

    @SerializedName("ISSUEKEY")
    private String projectKey;
    @SerializedName("STARTDATE")
    private String from;
    @SerializedName("ENDDATE")
    private String to;
    @SerializedName("BOOKINGTEXT")
    private String bookingtext;

    public Worktime(String from, String to, String projectKey) {
        this.from = from;
        this.to = to;
        this.projectKey = projectKey;
    }

    public String getFrom() {
        return from;
    }

    public String getFromAsDate() {
       try {
        return new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.GERMANY).parse(from);
       } catch (Exception e) {

        }
        return null;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public String getToAsDate() {
       try {
        return new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.GERMANY).parse(to);
       } catch (Exception e) {

        }
        return null;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    public String getBookingtext() {
        return bookingtext;
    }

    public void setBookingtext(String bookingtext) {
        this.bookingtext = bookingtext;
    }

    @Override
    public String toString() {
        return "Worktime{" +
                "from=" + from +
                ", to=" + to +
                ", projectKey='" + projectKey + '\'' +
                ", bookingtext='" + bookingtext + '\'' +
                '}';
    }

    public String toRequest()
    {
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.GERMANY);
        Date dStart = from;
        Date dEnd = to;
        dEnd.setHours(15);
        return String.format("{" +
                        "\"ISSUEKEY\":\"%s\"," +
                        "\"STARTDATE\":\"%s\"," +
                        "\"ENDDATE\":\"%s\"," +
                "\"BOOKINGTEXT\":\"%s\"" +
                               "}", projectKey, df.format(dStart), df.format(dEnd), bookingtext);
    }
}