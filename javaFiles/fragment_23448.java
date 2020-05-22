ResourcePermissionLocalServiceUtil.setResourcePermissions(companyId,
                Organization.class.getName(),
                ResourceConstants.SCOPE_GROUP_TEMPLATE, "0", CiUtils
                        .getRoleX().getPrimaryKey(),
                ORGANIZATION_MODEL_ACTION_IDS);

        // ORGANIZATION MODEL COMPANY PERMISSIONS
        ResourcePermissionLocalServiceUtil.setResourcePermissions(companyId,
                Organization.class.getName(), ResourceConstants.SCOPE_COMPANY,
                Long.toString(companyId),
                CiUtils.getRoleX().getPrimaryKey(),
                ORGANIZATION_MODEL_ACTION_IDS);

        // PORTAL (portlet 90) PERMISSIONS
        ResourcePermissionLocalServiceUtil.setResourcePermissions(companyId,
                "90", ResourceConstants.SCOPE_COMPANY,
                Long.toString(companyId),
                CiUtils.getRoleX().getPrimaryKey(),
                PORTAL_ACTION_IDS);

        // USER_ORG_ADMINS PORTLET (125) PERMISSIONS
        ResourcePermissionLocalServiceUtil.setResourcePermissions(companyId,
                "125", ResourceConstants.SCOPE_COMPANY,
                Long.toString(companyId),
                CiUtils.getRoleX().getPrimaryKey(),
                USERS_ORG_ADMIN_ACTION_IDS);