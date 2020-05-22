class MDetails {
    private MDetail M;
    // getter & setter
}

class MDetail {
    private ArrayList<Map<String, String>> row;
    // getter & setter
}

...
MDetails data = new Gson().fromJson(jsonString, MDetails.class);
for (Map<String, String> colMap : data.getM().getRow()) {
    for (String value : colMap.values()) {
        System.out.println(value);
    }
}