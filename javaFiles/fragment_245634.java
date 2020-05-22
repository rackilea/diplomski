Gson gson = new GsonBuilder()
            .registerTypeAdapter(UserLecture.class, new JsonDeserializer<UserLecture>() {
                public UserLecture deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                    JsonArray usersJsonArray = json.getAsJsonObject().getAsJsonArray("users");
                    JsonObject userJsonObject = usersJsonArray.getAsJsonArray().get(0).getAsJsonObject();
                    User user = new User();
                    user.setUserId(userJsonObject.get("user_id").getAsString());
                    user.setUserEmail(userJsonObject.get("user_email").getAsString());
                    user.setUserPassword(userJsonObject.get("user_password").getAsString());
                    Lecturer lecturer = new Lecturer();
                    lecturer.setLecturerId(userJsonObject.get("lecturer_id").getAsString());
                    lecturer.setLecturerName(userJsonObject.get("lecturer_name").getAsString());
                    return new UserLecture(lecturer, user);
                }
            })
            .create();

Retrofit retrofit = new Retrofit.Builder()
.baseUrl([YOUR_BASE_URL])
.addConverterFactory(GsonFactoryConverter.create(gson))
.build();