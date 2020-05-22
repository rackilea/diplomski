// default tika configuration can detect a lot of different file types
TikaConfig tika = new TikaConfig();

// meta data collected about the source file
Metadata metadata = new Metadata();
metadata.set(Metadata.RESOURCE_NAME_KEY, f.toString());

// determine mime type from file contents   
String mimetype = tika.getDetector().detect
    (TikaInputStream.get(uploadedFile2), metadata);
System.out.println("File " + uploadedFile2 + " is " + mimetype);