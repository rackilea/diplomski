ByteArrayOutputStream docOutputStream = new ByteArrayOutputStream();
((XmlDocument)domDocument).write(docOutputStream);
ByteArrayInputStream docInputStream = new
ByteArrayInputStream(docOutputStream.toByteArray());
InputSource inputSource = new InputSource(docInputStream);
parser.parse(inputSource);