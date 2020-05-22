@SuppressWarnings("restriction")
 BASE64Decoder decoder = new BASE64Decoder(); // Decode encoded string into original byte array
System.out.println("in try "); 
System.out.println("imagestring "+ imageString);
byte[] decoded = decoder.decodeBuffer(imageString);
System.out.println("image"+ decoded); 
BufferedImage image = ImageIO.read(new ByteArrayInputStream(decoded));

File f = new File(System.getenv("CATALINA_HOME") + "/temp");//TomcatHome director/tempfolder
System.out.println(f.getAbsolutePath());//debug like this
if(!f.exists()){
f.mkdir();//make temp folder if it does not exist
}
ImageIO.write(image, "jpg",new File(f.getAbsolutePath() + "/yourimagename.jpg"));//write image to to the temp folder
}
//do some other Processing
File file = new File(f.getAbsolutePath() + "/yourimagename.jpg");
if(file.exists()){
file.delete();
 }