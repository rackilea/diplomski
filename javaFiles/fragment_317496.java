private void getVendorsList(JsonObject body) {
    JsonArray jsonArray = body.getAsJsonArray("data");
    List<VendorModel> vendorModelList = new ArrayList<>();
    if(jsonArray != null) {
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject dataObject = jsonArray.get(i).getAsJsonObject();
            if(dataObject != null) {
                JsonObject resultObject = dataObject.getAsJsonObject("resultData");
                if(resultObject != null) {

                    //Manual parse
                    int id = resultObject.get("id").getAsInt();
                    String vendorName = resultObject.get("vendorName").getAsString();
                    String shortDescription = resultObject.get("shortDescription").getAsString();
                    String imageUrl = resultObject.get("imageUrl").getAsString();
                    String url = resultObject.get("url").getAsString();

                    VendorModel vendorModel = new VendorModel(id,vendorName, shortDescription, imageUrl, url);
                    vendorModelList.add(vendorModel);

                    //Parse using Gson. Also try this instead of above if your json key and model property are aligned
                    /*VendorModel vendorModel = new Gson().fromJson(resultObject, VendorModel.class);
                    vendorModelList.add(vendorModel);*/
                }
            }
        }
    }

    Log.d("vendorsList", String.valueOf(vendorModelList));
}