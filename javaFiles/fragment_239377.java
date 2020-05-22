for (Map.Entry<String, List<Map<String, String>>> csvDictEntry : csvDict.entrySet()) {
    // for each Map in List stored as value
    for (Map<String, String> hashListDict : csvDictEntry.getValue()) {
        // for each entry in hmap_2 print Value
        for (Map.Entry<String, String> entry : hashListDict.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}