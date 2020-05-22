String fileLoc = "/var/tmp/myImage.jpg";
String[] cmd = {"chmod", "0444", fileLoc};
ProcessBuilder pb = new ProcessBuilder(cmd);
Process process = pb.start();
int error = process.waitFor();
if (error != 0){
    //non 0 means something bad happend
}