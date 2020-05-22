String packageName = getMyClass().getPackage().getName();

    String directParent;
    if(packageName.contains(".")) {
        directParent = packageName.substring(1 + packageName.lastIndexOf("."));
    } else {
        directParent = packageName;
    }