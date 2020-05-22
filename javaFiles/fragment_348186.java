try{
        session = getSession();
        ProjectsDO project = em.find(ProjectsDO.class, id);
        // read the file name or the full path
        String fileName=project.getFileName();

        // read the content of the file
        byte[] fileContent = project.getFileContent();

       //compute the output file path (combine directory and file name)
       Path path = Paths.get("C:/Users/veerraju/Desktop/sap/projects/"+fileName);
       // this path was missing - fill the file with content
       Files.write(path,fileContent);
         System.out.println("file created succefully");
       } catch(IOException e){
         System.out.println(e.getMessage());
       }