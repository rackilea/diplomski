Map<Flag, Boolean> keyValueMap = file.findAllFiles(userid)
if(keyValueMap.contains(Flag.HAVE_FILES) == true){
     //send email
 }else{
     //do something
 }