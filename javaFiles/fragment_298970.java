public class Data {

    private final String name;
    private final String id;
    private final List<String> mailId;
    private final List<Opwarden> bundle1;

    public Data(final String name, final String id, final List<String> mailId, final List<Opwarden>     bundle1) {
        this.name = name;
        this.id = id;
        this.mailId = mailId;
        this.bundle1 = bundle1;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public List<String> getMailId() {
        return mailId;
    }

    public List<Opwarden> getBundle1() {
        return bundle1;
    }
}