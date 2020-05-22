Example t = new Example();
t.setText("abc"); // Set the text
t.getValueUnion().add("value1"); // Add some elements to list
t.getValueUnion().add("value2");

Serializer ser = new Persister(new AnnotationStrategy());
ser.write(t, f); // 'f' is the file to write