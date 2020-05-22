try {
    driveApi.grantPermission(userEmail, fileId, permission);
} catch(GoogleJsonResponseException cause) {
    if (documentsListApi.listPermissions(userEmail, fileId).contains(permission)) {
        //OK
    } else {
        throw cause;
    }
}