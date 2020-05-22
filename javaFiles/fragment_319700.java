@JsonSerialize(using = DataJsonSerializer.class)
class Data {

    public static final int DEFAULT_VALUE = 60;

    private int id;
    private int value = DEFAULT_VALUE;

    //getters, setters, toString, other
}