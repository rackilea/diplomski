class Response {
  int id;
  int field_id;
  ArrayList<ArrayList<Integer>> body; // or whatever type is most apropriate
}

responses = new Gson()
            .fromJson(draft, new TypeToken<ArrayList<Response>>(){}.getType());