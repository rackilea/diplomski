Collections.sort(list, new Comparator<Map<String, Object>>() {

    @Override
    public int compare(Map<String, Object> o1, Map<String, Object> o2) {
        String value1 = (String) o1.get("amount");
        String value2 = (String) o2.get("amount");
        return Integer.parseInt(value1)-Integer.parseInt(value2);
    }
});

for (Map<String, Object> map1 : list) {
    String id = (String) map1.get("id");
    String amount = (String) map1.get("amount");
    System.out.println("amount= "+amount + " , " +"id = "+id);
    List<LatLng> idlatlng = (List<LatLng>) map1.get("latlng");
}