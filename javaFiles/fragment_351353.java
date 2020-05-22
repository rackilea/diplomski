String[] command ={"/pathto/your/batch.sh", "commandLineParameter"};
//for example if you run your batch manually like 'mybatch.sh  today'
// so your command line parameter is today
ProcessBuilder pb = new ProcessBuilder(command);
pb.redirectOutput(new File("/tmp/output.txt"));
    //in the above output.txt you can see the output from the command
   while(true){
      try {
             Process p = pb.start();
             p.waitFor();
           } catch (InterruptedException e) {
                  e.printStackTrace();
           }catch (Exception e1) {
                  e1.printStackTrace();
       }
        if(something)//put your condition here when to break the loop
           break;
   }//end of while loop