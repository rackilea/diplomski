ConditionalPermissionInfo info = admin.newConditionalPermissionInfo(
    "name", 
    null, 
    new PermissionInfo[] { new PermissionInfo(
       "java.lang.RuntimePermission", "exitVm", "*") },
    ConditionalPermissionInfo.DENY
);

ConditionalPermissionUpdate update = admin
   .newConditionalPermissionUpdate();
update.getConditionalPermissionInfos().add(0, info);
update.commit();