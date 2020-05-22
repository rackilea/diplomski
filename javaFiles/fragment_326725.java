public Boolean containsSequences(String uname, String pwd){
  Boolean contains=false;
  int count=0;
  for (String seq: uname.split("/[\@\-\.\_]/g")){ //split the username following this regex.
     if(pwd.indexOf(seq)>0){
        count++;
     }
  }
  if(count>0){
     contains=true;
  }
  return contains;
}