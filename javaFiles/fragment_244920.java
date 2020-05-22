String username = formData.getFirst(RegistrationPage.FIELD_USERNAME);

UserModel user = formContext.getSession().users()
        .addUser(formContext.getRealm(), username);

user.setEnabled(true);

user.grantRole(context.getRealm().getRole("user"));