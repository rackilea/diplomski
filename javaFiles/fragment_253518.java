@ExternalRestrictions("Edit User")
   public static void submit(@Valid models.User user) {


        Logger.info("flashUserId in Submit: " + flash.get("user") + " and user id is : " + user.id);
        validation.valid(user);
        if(validation.hasErrors() && flash.get("user") == null) {
            List<Role> roles = Role.findAll();
            Logger.info("hasError");

            render("@edit", user, roles);
        }

        Logger.info ("id: "+ user.geoUpazilla.id);   
        if(flash.get("user") != null){

            User editedUser = User.findById(Long.parseLong(flash.get("user")));

            editedUser.name = user.name;
            editedUser.displayName = user.displayName;
            editedUser.email = user.email;
            editedUser.role = user.role;
            editedUser.school= user.school;
            editedUser.ngo = user.ngo;
            editedUser.geoDivision = user.geoDivision;
            editedUser.geoDistrict = user.geoDistrict;
            editedUser.geoUpazilla = user.geoUpazilla;

            Logger.info("id : " + editedUser.id + " name: " + editedUser.name + " displayname: " + editedUser.displayName + " email: " + editedUser.email + " role: " + editedUser.role.id + " ngoId: " + editedUser.ngo.id + " geoDivisionId: " 
            + editedUser.geoDivision.id + " geoDistrictId: "+ editedUser.geoDistrict.id + " geoUpazilaId: "+ editedUser.geoUpazilla.id);

            editedUser.save();


        }
        else {
            user.save();
            create();
        }

        flash.success("Record saved successfully.");
        list("0");
    }