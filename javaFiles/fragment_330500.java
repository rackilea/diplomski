@Component("fileUpload") 
public class FileUploadUtil implements FileUpload { 

 private String filePath; 
 @Value("#{prop.filePath}") 
 public void setFilePath(String filePath) { 
  System.out.println(filePath); 
  this.filePath = filePath; 
 }