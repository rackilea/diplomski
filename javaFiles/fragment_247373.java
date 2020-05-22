public class MainRunner {
    // Use Path according to your file system
    private static String List1Path = "/List1.txt";

    // Use Path according to your file system
    private static String List2Path = "/List2.txt";

    public static void main(String...arg) throws UnsupportedEncodingException, IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String List1Content = new String(Files.readAllBytes(Paths.get(List1Path)), "UTF-8");

        Map<String, List<String>> map = new HashMap<>();

        map = gson.fromJson(List1Content, new TypeToken<Map<String, List<String>>>() {}.getType());

        System.out.println(map);

        String List2Content = new String(Files.readAllBytes(Paths.get(List2Path)), "UTF-8");

        List<Product> products = gson.fromJson(List2Content, new TypeToken<List<Product>>() {}.getType());

        System.out.println(products);

        List<JuniorArea> juniorAreas = new ArrayList<>();

        for (String s : map.keySet()) {
            JuniorArea juniorArea = new JuniorArea();

            juniorArea.setJuniorAreaDescription(s);

            List<MerchandisingGroup> merchandisingGroups = new ArrayList<>();

            List<String> subgroupCodes = map.get(s);

            for (String subgroupCode : subgroupCodes) {

                for (Product product : products) {

                    if (product.getSubgroupCode().equals(subgroupCode)) {
                        List<ProductGroup> productGroups = product.getProductGroup();

                        for (ProductGroup productGroup : productGroups) {
                            MerchandisingGroup merchandisingGroup = new MerchandisingGroup();

                            merchandisingGroup.setProductCode(productGroup.getProductCode());
                            merchandisingGroup.setProductDescription(productGroup.getProductDescription());

                            merchandisingGroups.add(merchandisingGroup);
                        }
                    }

                }

            }

            juniorArea.setMechandisingGroup(merchandisingGroups);

            juniorAreas.add(juniorArea);
        }

        JuniorAreaCollection collection = new JuniorAreaCollection();

        collection.setJuniorArea(juniorAreas);

        System.out.println(gson.toJson(collection));
    }
}