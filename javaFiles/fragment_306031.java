String json = "{\"cars\":{\"jeep\":{\"length\":4670,\"weight\":1450},\"ford\":{\"length\":4460,\"weight\":1880},\"count\":128}}";
Cars cars = new Cars();
cars.add("jeep", new Car(4670, 1450));
cars.add("ford", new Car(4460, 1880));

Gson gson = new GsonBuilder()
           .registerTypeAdapter(MyMap.class, new MyDeserializer())
           .registerTypeAdapter(MyMap.class, new MySerializer())
           .create();

String json2 = gson.toJson(cars);
cars = gson.fromJson(json, Cars.class);
cars = gson.fromJson(json2, Cars.class);