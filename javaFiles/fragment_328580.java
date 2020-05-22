List<Layout> tempPages = LayoutLocalServiceUtil.getLayouts( 0, LayoutLocalServiceUtil.getLayoutsCount() );
List<Role> allAvailRoles = RoleLocalServiceUtil.getRoles( 0, RoleLocalServiceUtil.getRolesCount() );
for ( Layout page : tempPages )
{
    List<Role> mappedRoles = new ArrayList<Role>();
    for ( Role role : allAvailRoles )
    {
        boolean hasRolePermission = PermissionLocalServiceUtil.hasRolePermission( role.getRoleId(),
                                                                                  page.getCompanyId(),
                                                                                  Layout.class.getName(),
                                                                                  ResourceConstants.SCOPE_INDIVIDUAL,
                                                                                  String.valueOf( page.getPrimaryKey() ),
                                                                                  "VIEW" );
        if ( hasRolePermission )
        {
           mappedRoles.add( role );
        }
     }
     pages.add( new LayoutRoleModel( page, mappedRoles ) );
}