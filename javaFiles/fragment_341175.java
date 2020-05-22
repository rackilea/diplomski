@DateRange.List({
        @DateRange(start = "startDate", end = "endDate", message = "Start date should be earlier than end date.")
})
public class MyClass {
    @NotNull
    @Pattern(regexp = DateConstants.DATE_FORMAT_REGEX, message = "Invalid date format.")
    public String startDate;

    @NotNull
    @Pattern(regexp = DateConstants.DATE_FORMAT_REGEX, message = "Invalid date format.")
    public String endDate;

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}