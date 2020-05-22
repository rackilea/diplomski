class A{

    JSONObject getJSON() {
        SimpleDateFormat DATEFORMATTER = new SimpleDateFormat("yyyy/MM/dd kk:mm:ss");
        jsonObject = new JSONObject();
        jsonObject.put("date",DATEFORMATTER.format(passing date object here));
    }
}