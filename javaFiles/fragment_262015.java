String input = "1477547160000+0800";
long epoch = Long.parseLong(input.substring(0, input.length() - 5));
int offset = Integer.parseInt(input.substring(input.length() - 5));
int offsetHour = offset / 100;
int offsetMin = offset % 100;

OffsetDateTime t = Instant
    .ofEpochMilli(epoch)
    .atOffset(ZoneOffset.ofHoursMinutes(offsetHour, offsetMin));