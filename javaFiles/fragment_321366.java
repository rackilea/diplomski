try {
    FileWriter fw2 = new FileWriter("C:\\SUMO\\bin\\OSMTEST.bat");
    fw2.write("@echo off");
    fw2.write("\r\n");
    //fw2.write("cmd");//No need to specify this line
    fw2.write("\r\n");
    fw2.write("set default_dir=C:\\SUMO\\bin");
    fw2.write("\r\n");
    fw2.write("start /b C:\\SUMO\\bin\\netconvert --osm-files="+osmFile_path+" --output-file="+osmnet_file);
    fw2.write("\r\n");
    fw2.write("Exit");//To close bat file
    fw2.write("\r\n");
    fw2.close();
    Process process = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:\\SUMO\\bin\\OSMTEST.bat");//use the protoclhandler
    process.waitFor();//Waits the process to terminate
    if (process.exitValue() == 0)
    {
        System.out.println("Process Executed Successfully");
    }
} catch(Exception e) {//Process.waitFor() can throw InterruptedException
e.printStackTrace();
}