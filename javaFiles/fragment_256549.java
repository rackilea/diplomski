@GroupSequence({ Inner.class, NewSlotBean.class })
@TotalBeanValid(groups = Default.class)
public class NewSlotBean {

    @DayMonthYearString(groups = Inner.class)
    private String slotDay;

    @TimeString(groups = Inner.class)
    private String slotBegin;

    @LengthString(groups = Inner.class)
    private String slotLength;
}