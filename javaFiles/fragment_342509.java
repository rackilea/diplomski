final String WWW = "WWW";
final String KG1 = "KG1";
final String KG2 = "KG2";
final String extension = ".ttl";

int id = 1;
int depth = 1;

String filePath = "." // current dir
  + File.separator 
  + WWW 
  + File.separator 
  + KG1 
  + File.separator 
  + depth 
  + File.separator 
  + id 
  + extension;

File file = new File(filePath);
// make sure parent dir exists (else created)
file.getParentFile().mkdirs(); 
FileWriter writer = new FileWriter(file);