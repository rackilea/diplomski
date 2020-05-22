public static List<ModuleVersion> findAll(String version) {
    return find.fetch("module").where().like("version", version).findList();
}

public static List<ModuleVersion> findFeatured(String version) {
    return find.fetch("module")
            .where().like("version", version).eq("module.isFeatured", true).findList();
}

public static List<ModuleVersion> findNotFeatured(String version) {
    return find.fetch("module")
            .where().like("version", version).eq("module.isFeatured", false).findList();
}