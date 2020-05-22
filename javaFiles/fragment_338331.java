String image = serviceModel.getImage();
String title = serviceModel.getTitle();
String description = serviceModel.getDescription();
String period = serviceModel.getPeriod();
int price = serviceModel.getPrice();

if (!tmpServiceClick.getImage().equals(image)) {
     parameters.putAll(RetrofitRequestUtil.fileToRequestBodyMap(file, "avatar"));
}
if (!tmpServiceClick.getTitle().equals(title)) {
     parameters.put("title", RetrofitRequestUtil.toRequestBody(title));
}
if (!tmpServiceClick.getDescription().equals(description)) {
     parameters.put("description", RetrofitRequestUtil.toRequestBody(description));
}
if (!tmpServiceClick.getPeriod().equals(period)) {
     parameters.put("period", RetrofitRequestUtil.toRequestBody(period));
}
if (tmpServiceClick.getPrice() != price) {
    parameters.put("price", RetrofitRequestUtil.toRequestBody(String.valueOf(price)));
}

retrofitInterface.editService(masterId, serviceModel.getPublicId(), parameters));