// via File - /data/data/your.package/app_assets/example.xml
File outputFile = new File(getDir("assets", Context.MODE_PRIVATE), "example.xml");
serializer.write(outputFile, result);

// via FileOutputStream - /data/data/your.package/files/example.xml
FileOutputStream outputStream = openFileOutput("example.xml", Context.MODE_PRIVATE);
serializer.write(outputStream, result);