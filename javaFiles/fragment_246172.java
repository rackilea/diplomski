String filenameBase = "myImage";
String currentTimestamp = new SimpleDateFormat("yyyymmddHHMMss").format(now());
File f = new File(filenameBase + currentTimestamp +  ".png");
for (int i = 0; f.exists(); i++) {
    f = new File(filenameBase + currentTimestamp +  "-" + i + ".png");
}
// so here, you will have a filename which is not yet exists in your filessystem