public static List<Module> findAllFeatured() {
    return find.select("id,name").where().eq("isFeatured", true).findList();
}

public static List<Module> findAllNotFeatured() {
    // give here list of field to select WITHOUT featured, otherwise it will 
    // create a JOIN to featured which will result that you will be not able
    // to get records without associations
    return find.select("id, name").where().eq("isFeatured", false).findList();
}