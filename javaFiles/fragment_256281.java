GsonBuilder gsonBuilder = new GsonBuilder();
 Gson gson = gsonBuilder.create();
 ExampleClass resultObj = gson.fromJson(jsonObject.toString(),ExampleClass.class);
 String status = resultObj.getStatus();
 String msg = resultObj.getMsg();
 List<Response> responseList = resultObj.getResponse();