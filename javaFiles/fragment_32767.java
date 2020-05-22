JsonArray array= rjson.getAsJsonArray();
Iterator iterator = array.iterator();
List<String> urlOfListingBeds = new ArrayList<String>();
while(iterator.hasNext()){
    JsonElement jsonElement = (JsonElement)iterator.next();
    JsonObject jsonObject = jsonElement.getAsJsonObject();
    JsonArray urlOfListingBed = jsonObject.getAsJsonArray("urlOfListingBeds");
    if(urlOfListingBed!=null){
        Iterator iter = urlOfListingBed.iterator();
        while(iter.hasNext()){
            JsonElement jsonElementChild = (JsonElement)iter.next();
            if(jsonElementChild!=null)
                urlOfListingBeds.add(jsonElement.getAsString());
        }
    }
}