<% 
        ProcessFile processFile2=(ProcessFile)application.getAttribute("processFile");
          // now start processing of file 
           if(null!=processFile2){

           processFile2.readFile();
          //open file if not. And read it.  

          //and after that. 
          processFile2.closeFileIfOpen();  
          // do neccesorry checks inside above method while closing file.  
          //all method are synchronized
          }
        %>