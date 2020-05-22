try(BufferedWriter bw = new BufferedWriter(new FileWriter("report.txt"))){
    for(File currentFile : filesToProcess){
        try{
            processor.processFile(currentFile);
            bw.write(currentFile.getName() + " - Passed\n" );
        }catch(Exception e){
            bw.write(currentFile.getName() + " - Failed " + e.getMessage() + "\n");
        }
    }
}catch(IOException e){
        e.printStackTrace();
}