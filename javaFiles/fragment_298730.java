GsonBuilder gsonBuilder =new  GsonBuilder();
gsonBuilder.registerTypeAdapter(Response.class, new CustomConvertor());
Gson gson = gsonBuilder.create();
GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);
Retrofit retrofit = new Retrofit.Builder()
         ...// other setups
        .addConverterFactory(gsonConverterFactory).build();