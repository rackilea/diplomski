String categoryIdJsonPath = 
        "$" +              // start from tree root
        ".listings[0]" +   // get listings array's first (only) object
        ".categories[0]" + // get categories array's first (only) object
        ".id";             // get id property
    String lastParentIdJsonPath = 
        "$" +                         // start from tree root
        ".listings[0]" +              // get listings array's first (only) object
        ".categories[0]" +            // get categories array's first (only) object
        "..parentCategory" +          // do deep scan for all nested parentCategory objects 
        "[?(!(@.parentCategory))]" +  // filter by the object that does NOT have parentCategory property
        ".id";                        // get id property
    try {
        // read the whole input so it can be scanned twice
        String jsonInput = new String(Files.readAllBytes(Paths.get("C://temp/test.json")), Charset.forName("UTF-8"));
        String categoryId = JsonPath.read(jsonInput, categoryIdJsonPath);
        System.out.println(categoryId);
        // return type is always List when deep scan is requested
        List<String> lastParent = JsonPath.read(jsonInput, lastParentIdJsonPath);
        System.out.println(lastParent.get(0));
    } catch (Exception e) {
        e.printStackTrace();
    }