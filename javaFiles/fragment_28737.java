// open the resource from raw file
InputStream ins = getResources().openRawResource(R.raw.myfile);
try {
  Reader reader = new BufferedReader(new InputStreamReader(ins, "UTF-8"));
  Writer writer = new StringWriter();
  int size;

  char[] buffer = new char[1024];
  // read the whole file to a writer.
  while ((size = reader.read(buffer)) >= 0) {
    writer.write(buffer, 0, size);
  }

  // now we have the string
  String json = writer.toString();
  Gson gson = new Gson();

  // translate it to the object.
  Studies study = gson.fromJson(json, Studies.class);

  // Now you have the correct object translated from the json file.

} catch (IOException e) {
  e.printStackTrace();
  // Error!! Do something here. Please don't ignore me.
}