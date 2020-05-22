public enum Entity {

    EntityA("student", "translation1", "translation2", "translation3", "translation4"),
    EntityB("faculty", "translation1", "translation2", "translation3", "translation4"),
    EntityC("staff", "translation1", "translation2", "translation3", "translation4");

    public String[] names;

    private Entity(String english, String spanish, String chinese, String german, String japanese) {
        names = new String[]{english, spanish, chinese, german, japanese};
    }
}