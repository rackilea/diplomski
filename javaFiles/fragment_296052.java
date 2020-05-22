if (ExpandoColumnPermission.contains(
            getPermissionChecker(), column, ActionKeys.VIEW)) {

        return expandoValueLocalService.getData(
            className, tableName, columnName, classPK);
    }
    else {
        return null;
    }