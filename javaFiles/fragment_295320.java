public static Result carResolver(String path) {

    String[] parts = path.split("/");
    int partsLength = parts.length;

    String country = (partsLength > 0) ? parts[0] : null;
    String manufacturer = (partsLength > 1) ? parts[1] : null;
    String carModel = (partsLength > 2) ? parts[2] : null;
    // etc

    switch (partsLength){
        case 0: return countrySelect();
        case 1: return allManufacturersIn(country);
        case 2: return allModelsOf(manufacturer);
        case 3: return singleViewFor(carModel);
        // etc
    }

    return notFound("Didn't find anything for required path...");
}