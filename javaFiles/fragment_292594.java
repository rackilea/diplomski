String size = "1024x768";
ProcessBuilder pb = new ProcessBuilder("convert", "-size", size,
        "xc:white", "-font",
        "/usr/share/fonts/truetype/ttf-dejavu/DejaVuSerif.ttf",
        "-pointsize", "12", "-draw",
        "text 300,300 \"*****@hotmail.com\"",
        "/home/djo/Pictures/rainy.jpeg");
pb.redirectErrorStream(true);

Process p = pb.start();
BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
String line = null;
while((line=br.readLine())!=null){
    System.out.println(line);
}
System.out.println(p.waitFor());