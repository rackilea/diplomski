Set<String> userNames = new HashSet<>();
userNames.add("def_username");
userNames.add("ghi_username");
userNames.add("jkl_username");
userNames.add("mno_username");
userNames.add("pqr_username");
userNames.add("stu_username");
userNames.add("vwx_username");

// assuming `user` is non-null
user = user.trim().toLowerCase();

if (user.equals("abc_username")) {
    verifyXYZPermission(Folder);
    verifyNoPermissionToDelete();
} else if (userNames.contains(user)) {
    if (user.equals("ghi_username")) {
        verifyNoPermissionToCreate(user, Folder, level2);
        verifyNoPermissionToUpdate(Folder);
    } else {
        verifyCreatePermission(level2);
        verifyPermisssionToUpdate(Folder);
    }
}