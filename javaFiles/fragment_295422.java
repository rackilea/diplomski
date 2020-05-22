public enum Color {
    RED("FF0000"),
    GREEN("00FF00"),
    BLUE("0000FF");
    private String code;
    public String getCode(){return code;}
    public void setCode(String code){this.code = code;}
    private Color(String code){this.code = code;}
}