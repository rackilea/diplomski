public static Result menu() {
        //rest omitted
        Profile profile1=Profile.find.byId(reg);
        //rest omitted
        return ok(profile.render("", profile1));
    }