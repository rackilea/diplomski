public class DateDeserializer implements JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonElement element, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
        Calendar calendar = null;
        if (element.isJsonObject()) {
            calendar = Calendar.getInstance();
            JsonObject jsonObject = element.getAsJsonObject();
            if (jsonObject.has("date")) {
                JsonElement dateElement = jsonObject.get("date");
                if (dateElement.isJsonObject()) {
                    JsonObject dateObject = dateElement.getAsJsonObject();
                    JsonElement year = dateObject.get("year");
                    JsonElement month = dateObject.get("month");
                    JsonElement day = dateObject.get("day");
                    calendar.set(Calendar.YEAR, year.getAsInt()); 
                    calendar.set(Calendar.MONTH, month.getAsInt() - 1);
                    calendar.set(Calendar.DAY_OF_MONTH, day.getAsInt());    
                }
            }


            if (jsonObject.has("time")) {
                JsonElement timeElement = jsonObject.get("time");
                JsonObject timeObject = timeElement.getAsJsonObject();
                JsonElement hour = timeObject.get("hour");
                JsonElement minute = timeObject.get("minute");
                JsonElement second = timeObject.get("second");
                JsonElement nano = timeObject.get("nano");
                calendar.set(Calendar.HOUR_OF_DAY, hour.getAsInt());
                calendar.set(Calendar.MINUTE, minute.getAsInt());
                calendar.set(Calendar.SECOND, second.getAsInt());
                calendar.set(Calendar.MILLISECOND, nano.getAsInt());
            } else {
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0); 
                calendar.set(Calendar.SECOND, 0); 
                calendar.set(Calendar.MILLISECOND, 0);
            }

        }
        if (calendar != null) {
            return calendar.getTime();
        } else {
            return null;
        }
    }
}