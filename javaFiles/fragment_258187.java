final Gson gson = new GsonBuilder()
        .registerTypeAdapter(User.class, new User.Deserializer())
        .registerTypeAdapter(Photo.class, new Photo.Deserializer())
        .create();
final Wrapper wrapper = gson.fromJson(JSON, Wrapper.class);
System.out.println(wrapper.user.id);
wrapper.user.photos.forEach(p -> System.out.println(p.url));