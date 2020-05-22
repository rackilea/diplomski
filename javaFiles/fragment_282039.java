public enum Permission {
    BUILD, BREAK, INTERACT;
}

public class Permissions {
    private final Set<Permission> alliance = EnumSet.noneOf(Permission.class);
    private final Set<Permission> outsiders = EnumSet.noneOf(Permission.class);

    public Set<Permission> alliance() {
        return alliance;
    }

    public Set<Permission> outsiders() {
        return outsiders;
    }
}