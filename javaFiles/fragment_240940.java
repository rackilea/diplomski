public class FilePermission extends AbstractMediator
{

  public boolean mediate(MessageContext context) { 
      try {
      File oldfile =new File("/ggmd/files/uploads/FIle contract1.csv");
        File newfile =new File("/ggmd/files/uploads/contract1.csv");

        if(oldfile.renameTo(newfile)){
            System.out.println("Rename succesful");
        }else{
            System.out.println("Rename failed");
        }

private final String commandPath = "/bin/bash";

private final String scriptPath = "/opt/file/contracts/tst/permissions.sh";


try {
        Process execCommand = new ProcessBuilder(commandPath, scriptPath).start();
        execCommand.waitFor();
    } catch (IOException e) {
        // handle exceptions
        System.out.println(e.getMessage());
    } catch (InterruptedException e) {
        System.out.println(e.getMessage());
    }


    return true;
  }
}