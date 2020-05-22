Map<String, List<String>> barcodeToRows = new HashMap<>();
for (List<String> item : items) {
    String bc = item.get(0);
    if (barcodeToRows.containsKey(bc)) {
        barcodeToRows.get(bc).add(item);
    } else {
        List<String> tmpList = new ArrayList<>();
        tmpList.add(item)
        barcodeToRows.put(bc, tmpList);
    }
}