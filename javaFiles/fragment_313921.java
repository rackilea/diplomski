UrlEncodedFormEntity entity = new UrlEncodedFormEntity(data, Consts.UTF_8);

request.setHeader("Content-type", "application/json");
request.setHeader("Authorization","Bearer bZXL7hwy5vo7YnbiiGogKy6WTyCmioi8");

request.setEntity(entity);