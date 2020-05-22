URL url = new URL("http://www.google.com");
URLConnection uc = url.openConnection();

InputStreamReader input = new InputStreamReader(uc.getInputStream());
BufferedReader in = new BufferedReader(input);
String inputLine;

 FileWriter outFile = new FileWriter("orhancan");
 PrintWriter out = new PrintWriter(outFile);

while ((inputLine = in.readLine()) != null) {
    out.println(inputLine);
}

in.close();
out.close();

File fXmlFile = new File("orhancan");
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse(fXmlFile);


NodeList prelist = doc.getElementsByTagName("body");
System.out.println(prelist.getLength());