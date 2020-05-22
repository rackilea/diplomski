public class ProcessMutlipartFile implements Callable<String>
{
   private MultipartFile file; 
   private String temp;
   private UploadService uploadService;

   // change to take the interface UploadService
   public ProcessMutlipartFile(MultipartFile file,String temp, UploadService uploadService )
   {
       this.file=file;
       this.temp=temp;
       this.uploadService=uploadService;
   }

   public String call() throws Exception 
   {
     return   uploadService.csvUpload(temp, file);
   }
}