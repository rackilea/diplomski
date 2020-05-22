public static void printArrayList(ArrayList<Map<String, Object>> arrayList) {

    for (Map<String, Object> entry : arrayList) {
        String myID = entry.get("id").toString();
        String mySKU = entry.get("sku").toString();
        System.out.print("id:" + myID + " sku: " + mySKU);
        System.out.println("-------------------");
    }
}