class Foo {

    @JsonDeserialize(using = XMLGregorianCalendarDeserializer.class)
    private XMLGregorianCalendar dateTime;

    ...
}