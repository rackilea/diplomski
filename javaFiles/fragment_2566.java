private Long buildBookingValidDate (TimeIntervalType validFor) {
    if(validFor.getStartTimeStamp() == null)
        return null;

    return DateUtils.toEpochMilli(validFor.getStartTimeStamp());
}