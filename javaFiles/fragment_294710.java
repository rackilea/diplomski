InputStream inputStream = context.getResources().openRawResource(R.raw.data);
BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
String line;

while ((line = reader.readLine()) != null) {
    // process single line here
}