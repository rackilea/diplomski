final GsonBuilder gsonBuilder = new GsonBuilder();
// Register custom type adapter factory
gsonBuilder.registerTypeAdapterFactory(new ATypeAdapterFactory());
final Gson gson = gsonBuilder.create();

A aSomeCaseTrue = new AImpl(true);
System.out.print("aSomeCaseTrue:" + gson.toJson(aSomeCaseTrue));
// writes; aSomeCaseTrue:{"x":0}


A aSomeCaseFalse = new AImpl(false);
System.out.print("aSomeCaseFalse:" + gson.toJson(aSomeCaseFalse););
// writes; aSomeCaseFalse:{"someCase":false}