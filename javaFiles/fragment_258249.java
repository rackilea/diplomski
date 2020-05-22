public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {


    public String marshal(LocalDateTime val) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return val.format(formatter);

    }


    public LocalDateTime unmarshal(String val) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(val, formatter);

    }

}