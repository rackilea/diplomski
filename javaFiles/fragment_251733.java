Gson gson = new Gson();
        String courseDataString = courseData.getString("courseList", "");
        JsonArray courseDataArray = new JsonParser().parse(courseDataString).getAsJsonArray();
        List NEWcoursesArrayList = new ArrayList();

        for(JsonElement json : array){
            if(json.toString().contains("header")) {
                NEWcoursesArrayList.add(gson.fromJson(json, CourseHeader.class));
            }
            else{
                NEWcoursesArrayList.add(gson.fromJson(json, CourseInfo.class));
            }
        }