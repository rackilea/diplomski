public class ProcessMutlipartFile implements Callable<String>
{
   private Mutlipartfile file; 
   private String temp;
   private UploadService uploadService;
   public ProcessMutlipartFile(Mutlipartfile file,String temp, UploadService uploadService )
   {
       this.file=file;
       this.temp=temp,
       this.uploadService=uploadService;
   }

   public String call() throws Exception 
   {

    return   uploadService.csvUpload(temp, file);
    }

 }