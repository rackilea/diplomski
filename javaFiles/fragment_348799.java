@Mapper
public abstract class SchedulePayloadMapper
{
    @Mappings({
        @Mapping(target = "name", source = "scheduleName"),
        @Mapping(target = "scheduler", source = "schedulerName"),
        @Mapping(target = "notificationPeriod", expression = "java(NotificationPeriodHelper.getConstrainedPeriod(xmlSchedule, notificationFrom, notificationTo))"),
        @Mapping(target = "schedulePeriod", expression = "java(NotificationPeriodHelper.getConstrainedPeriod(xmlSchedule, scheduleFrom, scheduleTo))")
    })
    public abstract SchedulePayload map(XmlSchedule xmlSchedule, Lecture lecture);

    @AfterMapping
    protected void addPeriods(@MappingTarget SchedulePayload result, XmlSchedule xmlSchedule, Lecture lecture) {
        result.setNotificationPeriod(..);
        result.setSchedulePeriod(..);
    }
}