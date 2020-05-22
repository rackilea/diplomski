@GetMapping(value="/file_download",

produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
  )
@ResponseBody
public FileSystemResource downloadFile(@RequestParam String filename) throws IOException{

//to consume http://youserver/file_download?filename=mytest

try{


  System.out.println("in file download " +filename);

   String path = "src/main/resources/public/makingAPK/"+filename+"/"+filename+".apk"; //path of your file


    return new FileSystemResource(new File(path));
}

catch(Exception e){System.out.println("error in file_download "+e); return null;}

}