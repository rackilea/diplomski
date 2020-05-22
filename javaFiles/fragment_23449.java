ResourcePermissionLocalServiceUtil.setResourcePermissions(organization.getCompanyId(),
                            Organization.class.getName(),   ResourceConstants.SCOPE_INDIVIDUAL, Long                    .toString(organization.getPrimaryKey()),
                                MyUtils.getRoleX().getPrimaryKey(),
                                ORGANIZATION_ENTRY_ACTION_IDS);
        long groupId = organization.getGroupId();

        ResourcePermissionLocalServiceUtil.setResourcePermissions(
                    organization.getCompanyId(),Group.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,Long.toString(groupId),
                    MyUtils.getRoleX().getPrimaryKey(),
                    ORGANIZATION_GROUP_ENTRY_ACTION_IDS);