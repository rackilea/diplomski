protected String doInBackground(String... args) {
  String xml = "";

  if (args.length > 0) { 
   String url = args[0];
    Log.i("URL", url);
    xml = Function.executeGet(url);
  }

   return xml;
}