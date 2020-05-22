public final class CreateViaMethod {
    private final String name;

    private CreateViaMethod(String name) {
        this.name = name;
    }

    public static CreateViaMethod newInstance(String name) {
        return new CreateViaMethod(name);
    }
}