switch (RsqlSearchOperation.getSimpleOperator(operator)) {

        case EQUAL: {
            if (doesClassContainProperty(UserProfile.class, property)) {
                Join<User, UserProfile> profileJoin = root.join("user_profile_id");
                return builder.equal(profileJoin.get(property), argument);
            } else {
                return builder.equal(root.get(property), argument);
            }
        }