EntityIterable publicRead = txn.find(entityType, "publicRead", true);

EntityIterable result;

if (authId == null) {
    result = publicRead;
} else {
    result =
        txn.getAll(entityType).minus(publicRead).intersect(txn.find(entityType, "read(userIdauthIdRoleId)", true))
        .union(publicRead.intersect(txn.find(entityType, "read(" + authId + ")", true)));
}

result = result.skip(skip).take(limit);