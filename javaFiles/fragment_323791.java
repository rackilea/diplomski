.filter(a -> {
    if (a.getJavaType().getSimpleName().equalsIgnoreCase("string")) {
        return true;
    } else {
        return false;
    }
})