public enum Regular {
    NONE,
    HOURLY,
    DAILY,
    WEEKLY;

    public String getName() {
        return this.name().toLowerCase();
    }

    public static Regular valueOfByName(String name){
        return valueOf(name.toUpperCase());
    }
}