File myFile = new File("/sys/devices/virtual/dmi/id/chassis_serial");
byte[] fileBytes; 
String content = "";
if(myFile.exists()) {
    fileBytes = File.readAllBytes(myfile.toPath);
    if(fileBytes.length > 0) content = new String(fileBytes);
    else System.out.println("No file");
else System.out.println("No file");