String value = yourEditText.getText().toString();
String[] floatStrings = value.split(",");
float[] result = new float[floatString.length];
for (int i=0; i<result.length; i++) {
    result[i] = Float.valueOf(floatStrings[i];
}