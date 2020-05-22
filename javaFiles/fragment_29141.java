Result<UserRecord> users = create
    .select(USER.ID, USER.EMAIL)
    .from(USER)
    .where(USER.ID.in(userIdsToUpdate))
    .fetchInto(USER);

for (UserRecord user : users)
    user.setEmail(hash(user.getEmail()));

create.batchUpdate(users);