public class GsonIso8601Datelizer implements JsonSerializer<Date>, JsonDeserializer<Date> {

private static final String COMPAT_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
private static final char COLON = ':';
private static final char ISO8601_TZ_INFO_IS_JUST_Z = 'Z';
private static final int ISO8601_COLON_INDEX = 26;

private final SimpleDateFormat mSimpleDateFormat;

public GsonIso8601Datelizer() {
    mSimpleDateFormat = new SimpleDateFormat(COMPAT_FORMAT_STRING);
}


@Override
public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
    if (src == null) {
        return null;
    } else {
        StringBuilder stringBuilder;
        synchronized (this) {
            stringBuilder = new StringBuilder(mSimpleDateFormat.format(src));
        }

        stringBuilder.insert(ISO8601_COLON_INDEX, COLON);
        return new JsonPrimitive(stringBuilder.toString());
    }
}


@Override
public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    if (json.isJsonNull() || TextUtils.isEmpty(json.getAsString())) {
        return null;
    } else {
        StringBuilder stringBuilder = new StringBuilder(json.getAsString().trim());
        if (stringBuilder.charAt(stringBuilder.length() - 1) == ISO8601_TZ_INFO_IS_JUST_Z) {
            stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "+0000");
        } else {
            stringBuilder.deleteCharAt(ISO8601_COLON_INDEX);
        }

        Date date;
        synchronized (this) {
            try {
                date = mSimpleDateFormat.parse(stringBuilder.toString());
            } catch (ParseException e) {
                throw new IllegalArgumentException("Couldn't parse date string. " +
                        "Original: " + json.getAsString() + "; " +
                        "After custom processing: " + stringBuilder.toString());
            }
        }
        return date;
    }
}