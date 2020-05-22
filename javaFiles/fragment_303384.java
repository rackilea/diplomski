Gson gson = new GsonBuilder().setPrettyPrinting().create();

MyClazz myClazz = gson.fromJson("{\"device_identifier\":\"324234234\",\"name\":\"NameMe\",\"list\":[{\"prop\":\"A\",\"prop2\":-10},{\"prop\":\"B\",\"prop2\":-12}]}", MyClazz.class);
MyClazzWrapper wrapped = new MyClazzWrapper(myClazz);

System.out.println(gson.toJson(wrapped));