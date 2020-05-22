public static void main(String[] args) {
        String jsonString = "{\"auditorium\":\"506\",\"beginLesson\":\"10:30\",\"date\":\"2016.09.12\",\"dayOfWeekString\":\"Monday\",\"discipline\":\"Math\",\"endLesson\":\"11:10\",\"kindOfWork\":\"Lesson\",\"lecturer\":\"John Smith\"}";
        Gson gson = new GsonBuilder().setDateFormat("yyyy.MM.dd")
                .registerTypeAdapter(LocalTime.class, new LocalTimeDeserializer()).create();

        Auditorium auditorium = gson.fromJson(jsonString, Auditorium.class);
        System.out.println(auditorium.toString());

    }