public static class StudentAdapter extends TypeAdapter<Student> {
    public void write(JsonWriter writer, Student student)
            throws IOException {
        if (student == null) {
            writer.nullValue();
            return;
        }
        writer.beginObject();

        writer.name("name");
        writer.value(student.name);

        writer.name("sequence");
        writeSequence(writer, student.sequence);

        writer.endObject();
    }

    private void writeSequence(JsonWriter writer, List<Integer> seq)
            throws IOException {
        writer.beginObject();
        for (int i = 0; i < seq.size(); i++) {
            writer.name("index_" + i);
            writer.value(seq.get(i));
        }
        writer.endObject();
    }

    @Override
    public Student read(JsonReader in) throws IOException {
        // This is left blank as an exercise for the reader
        return null;
    }
}