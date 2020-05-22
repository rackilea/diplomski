@XStreamConverter(HolidayTransformer.class)
public enum Holiday {

CHRISTMAS("Christmas"),NEW_YEAR("New Year"),INDEPENDENCE_DAY("independence-day");

private String extendedName;

private Holidays(String extendedName) {
this.extendedName = extendedName;
}

public static Holiday fromString(String type) throws Exception {...}
}