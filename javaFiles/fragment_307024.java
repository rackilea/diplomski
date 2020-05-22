try (InputStream is = Files.newInputStream(Paths.get("C://temp/test.json"))) {
        // get all 'Product_Type__c' properties wherever they are
        JSONArray productTypes = JsonPath.read(is, "$..Product_Type__c");
        System.out.println(productTypes.get(0));
    } catch (Exception e) {
        e.printStackTrace();
    }