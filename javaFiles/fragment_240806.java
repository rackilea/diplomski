public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<String, Object>();
        // convert JSON string to Map
        map = mapper.readValue(new File("c://drive//test.json"), new TypeReference<Map<String, Object>>() {
        });
        System.out.println("map " + map);

        // Value of result element i.e array
        List<Map<String, Object>> result = (List<Map<String, Object>>) map.get("result");
        System.out.println("result " + result);
        // Traverse over array, Each element inside is one more object (ASSUMPTION 2)
        for (Map<String, Object> resultMap : result) {
            List<String> traversed = new ArrayList<>();
            // Traverse over each object
            for (Entry<String, Object> entry : resultMap.entrySet()) {
                // Each object contains a list
                List<String> insideMostArray = (List<String>) entry.getValue();
                // Entries to remove
                Map<String, Integer> removedEntry = new HashMap<>();
                // Inside most values
                for (String insideMostArrayTemp : insideMostArray) {
                    if (traversed.contains(insideMostArrayTemp)) {
                        removedEntry.put(insideMostArrayTemp, removedEntry.get(insideMostArrayTemp) == null ? 2
                                : (removedEntry.get(insideMostArrayTemp) + 1));
                    } else {
                        traversed.add(insideMostArrayTemp);
                    }
                }
                //Remove all duplicate entries and replace with 1 entry
                for (Entry<String, Integer> entriesToRemove : removedEntry.entrySet()) {
                    insideMostArray.removeAll(Collections.singleton(entriesToRemove.getKey()));
                    insideMostArray.add(entriesToRemove.getKey() + " (" + entriesToRemove.getValue() + ")");
                }
            }
        }
        String optimizedJson = mapper.writeValueAsString(result);
    }