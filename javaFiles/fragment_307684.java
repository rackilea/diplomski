boolean contains = false;

do {
    String gekozenCat = geefNamenCat("\nKies 1 van de volgende categorieën: ");

    for (String[] sub : Arrays.asList(TERADENWOORDEN))
        if (Arrays.asList(sub).contains(gekozenCat)) {
            contains = true;
            break;
        }

    if (! contains) {
        // print something
    }

} while (! contains);