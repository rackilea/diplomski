public class MyBean implements Serializable {
    private Date postDate;

    // ... constructors, etc

    @JsonSerialize(using = MyCustomDateSerializer.class)
    public Date getPostDate() {
        return postDate;
    }
}

public class MyCustomDateSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(final Date date, final JsonGeneraror generator,
          final SerializerProvider provider) throws IOException,
          JSONProcessingException {

        generator.writeString(yourRepresentationHere);
    }
}