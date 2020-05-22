JSONArray jA  = new JSONArray()
for(int j=0; j<condition;j++){
    JSONObject pa = new JSONObject();
    for(int i=0; i<name.length;i++) {
        childData = new JSONObject();
        childData.put("Name", name[i]);
        childData.put("Qty", qty[i]);
        childData.put("Amt", price[i]);
        pa.put("Detais",childData);
    }
    jA.put(pa);
}