Iterator<File> picFiles = 
  FileUtils
  .iterateFiles(
     uploadFile.getParentFile(),  
     new WildcardFileFilter("*_fact_1.*"), 
     null
   );