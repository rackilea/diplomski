fileObject.setRealName(realName);
        fileObject.setListDeptAccessor(departmentSharee);
        fileObject.setListUserAccessor(userSharee);
        fileObject.setUserCreator(owner);

        for(Department dep: departmentSharee){
            dep.getFileHasAccess().add(fileObject);
        } 

        for(User user: userSharee){
            user.getDeptFileHasAccess().add(fileObject);
        }