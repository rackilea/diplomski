TypeToken<ActivationFunction> functionTypeToken = new TypeToken<ActivationFunction>() {};

RuntimeTypeAdapterFactory<ActivationFunction> typeFactory = 
RuntimeTypeAdapterFactory.of(ActivationFunction.class, "type")
                         .registerSubtype(LinearFunction.class, "linear");

final Gson gson = new GsonBuilder().registerTypeAdapterFactory(typeFactory).create();