private String getValue(String valueOf) {
    int resourceVal = 0;
    switch(valueOf) {
        case "a":
            resourceVal = R.string.a;
            break;
        case "b":
            resourceVal = R.string.b;
            break;
    }
    if (resourceVal != 0) {
        return getResources().getString(resourceVal);
    }
    return "";
}