public class Profiles extends Controller {

    public static Result create() {
        profiles profile = new profiles();
        profile.description = "Testing";
        profile.profile = "Test Profile";

        role role = new models.role();
        role.description = "Test Role 1";
        role.role = "Role 1";
        profile.roles.add(role);

        role = new models.role();
        role.description = "Test Role 2";
        role.role = "Role 2";
        profile.roles.add(role);

        profile.save();

        List<profiles> profiles = Ebean.find(profiles.class).findList();
        for (profiles p : profiles) {
            Logger.info("Profile: {}", p.profile);
            for (role r : p.roles) {
                Logger.info("\t-> has role: {}", r.role);
            }
        }

        return ok(Json.toJson(profiles)).as("application/json");
    }
}