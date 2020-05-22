public class CustomDeserializer implements Deserializer<Date> {

    @Override
    public Date deserialize(String topic, byte[] data) {
        String strDate = new String(data);
        return new Date(Long.parseLong(strDate.substring(0, strDate.indexOf(";"))));
    }
}