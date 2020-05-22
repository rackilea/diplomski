class MyClass {
    //...Fields

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @JsonDeserialize(using = MyJsonDateDeserializer.class)
    private Date date;

    //...Fields
}