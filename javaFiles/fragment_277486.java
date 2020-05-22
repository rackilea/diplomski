public class PersonRequest {
    @NotNull
    private String name;

    public PersonRequest() {
    }

    public PersonRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}