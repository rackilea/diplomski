class CityRegistry {
    private static Map<String, City> references = new HashMap<>();
    public static void registerCity(String id, City reference) {
        references.put(id, reference);
    }

    public static City getCity(String id) {
        return references.get(id);
    }
}