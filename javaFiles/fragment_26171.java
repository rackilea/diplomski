switch (car) {
    case "BMW":
        updateBmwSpecs();
        doCommon();
        break;

    case "Mercedes":
        updateMercedesSpecs();
        doCommon();
        break;

    case "Ferrari":
        break;

    // remaining cases
}

private void doCommon() {
    // do whatever logic be common to BMW and Mercedes
    // e.g. take joy rides through the city and get too many car washes
}