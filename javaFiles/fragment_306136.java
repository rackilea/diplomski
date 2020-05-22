public static void main(String[] args) {
        String jsonString = "{\"name\":\"John\",\"studentClass\":\"1\"}";
        //String jsonString = "{\"name\":\"John\"}";

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Student.class, new StudentModelDeserializer())
                .create();

        Student student = gson.fromJson(jsonString, Student.class);
        System.out.println(student.toString());

    }