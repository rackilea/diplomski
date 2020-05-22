List<ResourcePermissionDTO> permissions = ...;
ResourcePermissionDTO result = null;

for (ResourcePermissionDTO p: permissions) {
    if (result == null || isStronger(p.getPermissionType(), result.getPermissionType())) {
        result = p;
        if (result.getPermissionType() == PermissionType.DENY) break; // (1)
    }
}

return result;