template.update(userAttempts, update -> update
                .set(userAttempts.attempts, (short) 0)
                .setNull(userAttempts.lastmodified)
                .where(userAttempts.username.eq(username))
                .execute()
);