public static long chunkSize(File file){
  //We don't want to create more that 1024 temp files for sorting
  final long MAX_AMOUNT_OF_TEMP_FILES = 1024;
  long fileSize = file.length();
  long freeMemory = Runtime.getRuntime().freeMemory();

  //We want to divide the file size by the maximum amount of temp files we will use for sorting
  long chunkSize = fileSize / MAX_AMOUNT_OF_TEMP_FILES;

  //If the block size is less than half the available memory, then we can stand to make the block size larger
  if(chunkSize < freeMemory / 2)
     chunkSize = freeMemory / 2;
  else
     System.out.println("Me may potentially run out of memory");

  return chunkSize ;

}