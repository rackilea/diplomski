@ModelAttribute("roles")
public List<Role> getRoles() {

    List<Role> allRoles = new ArrayList<Role>();
    try {
        allRoles = RoleLocalServiceUtil.getRoles(QueryUtil.ALL_POS,  
    ueryUtil.ALL_POS);
    } catch (SystemException e) {
        logger.error("Could Not get any Liferay Roles" + e.getMessage(), e);
    }
    return allRoles;
}