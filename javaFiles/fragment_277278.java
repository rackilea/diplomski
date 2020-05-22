public final class Foo {
    public static void main(String[] args) { //Just for testing
        final UUID uuid = UUID.randomUUID();
        newPlayer(uuid);

        addPackage(uuid, Package.LUCK_1);
        addPackage(uuid, Package.LUCK_2);

        System.out.println(hasPackage(uuid, Package.LUCK_1));
        System.out.println(hasPackage(uuid, Package.LUCK_2));
        System.out.println(hasPackage(uuid, Package.LUCK_3));

        System.out.println(PACKAGE_MAP.toString());
    }

    private static final Map<UUID, List<Package>> PACKAGE_MAP = new HashMap<>();

    public static void newPlayer(UUID uuid) {
        List<Package> n = new ArrayList<>();
        n.add(Package.JMSG_DEFAULT);
        PACKAGE_MAP.put(uuid, n);
    }

    public static boolean addPackage(UUID uuid, Package pack) {
        if (!PACKAGE_MAP.containsKey(uuid)) return false;

        if (!PACKAGE_MAP.get(uuid).contains(pack)) {
            List<Package> op = PACKAGE_MAP.get(uuid);
            op.add(pack);
            //removed `remove` and `put` here.
            return true;
        }
        return false;
    }

    public static boolean hasPackage(UUID uuid, Package pack) {
        if (!PACKAGE_MAP.containsKey(uuid)) return false;
        return PACKAGE_MAP.get(uuid).contains(pack);
    }
}