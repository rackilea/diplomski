int flag=0;
for(File file : files){
    if(file.isFile()){      
        filesListInDir.add(file.getAbsolutePath()); // what is the utility of this ??
        if(file.getName().equalsIgnoreCase(fileName)){
            flag = 1;
            response.setContentType("application/zip"); 
    response.setHeader("Content-Disposition","inline; filename=" + fileName );

            session.setAttribute("fileName", file.getName());
            FileInputStream fileInputStream = new FileInputStream(file.getPath());  
            int i;   
            while ((i=fileInputStream.read()) != -1) {  
               out.write(i);   
            }//closes while   
            fileInputStream.close();   
            out.close();   
            return; //you finished if you sent the file
         }  // closes if(file.getName().equalsIgnoreCase(fileName))
    } // closes if(file.isFile())

}// closes for

//following block moved after the for so it prints at most once
if(flag == 0){
    System.out.println("file not match");
    out.print("Answer is not uploaded");
}