import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class GsonApp {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        System.out.println(gson.toJson(new DatesPojo(new Date())));
    }

}

class CustomDateJsonSerializer implements JsonSerializer<Date> {
    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        String format = src.toInstant().atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ISO_TIME);
        return new JsonPrimitive(format + " ISO TIME");
    }
}

class DatesPojo {

    @JsonAdapter(CustomDateJsonSerializer.class)
    @SerializedName("customDate")
    private final Date mDate0;

    @SerializedName("effectiveDate")
    private final Date mDate1;

    public DatesPojo(Date mDate) {
        this.mDate0 = mDate;
        this.mDate1 = mDate;
    }

    public Date getmDate0() {
        return mDate0;
    }

    public Date getmDate1() {
        return mDate1;
    }
}