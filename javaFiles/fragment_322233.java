public class StudentAdapter extends TypeAdapter<Student> {

    public StudentAdapter() {
        super();
    }

    @Override
    public Student read(final JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        }

        final Student student = new Student();

        reader.beginObject();
        while (reader.hasNext()) {
            final String name = reader.nextName();
            if ("firstName".equals(name)) {
                student.setFirstName(reader.nextString());
            } else if ("lastName".equals(name)) {
                student.setLastName(reader.nextString());
            } else if ("schoolId".equals(name)) {
                student.setSchoolId(reader.nextString());
            }
        }
        reader.endObject();

        return student;
    }

    @Override
    public void write(final JsonWriter writer, final Student student)
            throws IOException {
        if (student == null) {
            writer.nullValue();
            return;
        }

        writer.beginObject();
        writer.name("firstName");
        writer.value(student.getFirstName());
        writer.name("lastName");
        writer.value(student.getLastName());
        writer.name("schoolId");
        writer.value(student.getSchoolId());
        writer.endObject();
    }
}