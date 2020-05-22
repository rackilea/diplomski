public class CustomDateSerializer extends JsonSerializer<Date> {  

    public void serialize(Date value, JsonGenerator gen, SerializerProvider arg2) throws 
        IOException, JsonProcessingException {      

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy H:m:s");
        String formattedDate = formatter.format(value);
        gen.writeString(formattedDate);
    }
}