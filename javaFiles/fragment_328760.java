class StudentAdapter extends TypeAdapter<Student>
{

    @Override
    public void write(JsonWriter out, Student s) throws IOException {
        out.beginObject();
        out.name("age");
        out.value(s.getAge());
        out.name("name");
        out.value(s.getName());
        out.endObject();
    }

    @Override
    public Student read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return null;
          }


        in.beginObject();
        Student s = new Student();
        while (in.peek() == JsonToken.NAME){
            String str = in.nextName();
            fillField(in, s, str);
        }


        in.endObject();
        return s;
    }

    private void fillField(JsonReader in, Student s, String str)
            throws IOException {
        switch(str){
            case "age": s.setAge(in.nextInt());
            break;
            case "name": s.setName(in.nextString());
            break;
        }
    }
}