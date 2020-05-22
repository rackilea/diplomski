import org.apache.commons.io.FilenameUtils

class firstclass {

   def  wluid,  wlpwd,  wlserver, port

   private wlconnection, connectString, jmxConnector, Filpath, Filpass, Filname, OSRPDpath, Passphrase

   // object constructor
   firstclass(wluid, wlpwd, wlserver, port) {            
       this.wluid = wluid
       this.wlpwd = wlpwd
       this.wlserver = wlserver
       this.port = port

        }

   def isFile(Filpath) {
       // Create a File object representing the folder 'A/B'
       def folder = new File(Filpath)

       if (!org.apache.commons.io.FilenameUtils.isExtension(Filpath, "txt")) {
           println "bad extension"
           return false
       } else if (!folder.exists()) {
           // Create all folders up-to and including B
           println " path is wrong"
           return false
       } else
           println "file found"
       return true
   }
}