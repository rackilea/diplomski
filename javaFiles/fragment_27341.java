public String[] getCreateRoleIdsArray() {
    return createRoleIds.split(",");
}

public void setCreateRoleIdsArray(String[] selectedRoles) {
    Logger.getLogger(this.getClass()).error("setCreateRoleIdsArray");
    String selRoles = new String();
    for (String role : selectedRoles) {
        selRoles = selRoles + "," + role;
    }
    setCreateRoleIds(selRoles);
}